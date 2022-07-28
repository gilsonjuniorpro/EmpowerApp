package empower.ca.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import empower.ca.adapter.EmpowerAdapter
import empower.ca.databinding.FragmentEmpowerBinding
import empower.ca.model.Content
import empower.ca.model.ContentWrapper
import empower.ca.sealed.Option
import empower.ca.sealed.Power
import empower.ca.viewmodel.ContentViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [EmpowerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EmpowerFragment : Fragment() {

    private lateinit var power: Power
    private var instanceHashCode: Int = 0
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var empowerAdapter: EmpowerAdapter
    private val viewModel: ContentViewModel by viewModels()
    lateinit var binding: FragmentEmpowerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmpowerBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            instanceHashCode = arguments?.getInt(INSTANCE_HASH_CODE) ?: 0

            val contentWrapper: ContentWrapper =
                arguments?.getParcelable(EMPOWER_CONTENT_OBJECT) ?: ContentWrapper()

            val option = arguments?.getParcelable(EMPOWER_OPTION_OBJECT) ?: Option.Container()
            if (!option.title.isNullOrEmpty() || !option.linkText.isNullOrEmpty()) {
                option.title?.let {
                    binding.containerTitle.text = option.title
                    binding.containerTitle.visibility = View.VISIBLE
                }

                option.linkText?.let {
                    binding.containerAction.text = option.linkText
                    binding.containerAction.visibility = View.VISIBLE
                }
            } else {
                if(contentWrapper.containerTitle.isNotEmpty()){
                    binding.containerTitle.text = contentWrapper.containerTitle
                    binding.containerTitle.visibility = View.VISIBLE
                }else{
                    binding.titleLinkContainer.visibility = View.GONE
                }
            }

            power = arguments?.getParcelable(EMPOWER_POWER_OBJECT) ?: Power.Basic

            linearLayoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            if (power is Power.Banner || power is Power.Expose) {
                linearLayoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }

            initAdapter(contentWrapper.contentType)

            if (contentWrapper.contents.isEmpty()) {
                loadInfo()
                viewModel.listContent(power)
            } else {
                empowerAdapter.submitList(contentWrapper.contents)

                handleData(contentWrapper.contents)
            }
        }
    }

    private fun initAdapter(contentType: String) {
        empowerAdapter = EmpowerAdapter(power, contentType)

        with(binding.feedRecycler) {
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
            adapter = empowerAdapter
            smoothScrollToPosition(0)
        }
    }

    private fun loadInfo() {
        viewModel.content.observe(viewLifecycleOwner) { list ->
            empowerAdapter.submitList(list)

            handleData(list)
        }
    }

    private fun handleData(list: List<Content>) {
        if (power is Power.Banner) {
            val pager = PagerSnapHelper()
            pager.attachToRecyclerView(binding.feedRecycler)

            val params: ConstraintLayout.LayoutParams =
                binding.feedRecycler.layoutParams as ConstraintLayout.LayoutParams
            params.height = ConstraintLayout.LayoutParams.WRAP_CONTENT
            params.width = ConstraintLayout.LayoutParams.MATCH_PARENT
            binding.feedRecycler.layoutParams = params

            binding.indicatorView.apply {
                visibility = View.VISIBLE
                setRecyclerView(
                    binding.feedRecycler, linearLayoutManager, list.size,
                    linearLayoutManager.findLastVisibleItemPosition(), false
                )
            }
        } else {
            val params: ConstraintLayout.LayoutParams =
                binding.feedRecycler.layoutParams as ConstraintLayout.LayoutParams
            params.height = ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
            params.width = ConstraintLayout.LayoutParams.MATCH_CONSTRAINT
            //params.height = ConstraintLayout.LayoutParams.WRAP_CONTENT
            //params.width = ConstraintLayout.LayoutParams.MATCH_PARENT
            binding.feedRecycler.layoutParams = params

            binding.indicatorView.apply {
                visibility = View.GONE
            }
        }
    }

    companion object {
        const val EMPOWER_POWER_OBJECT = "power"
        const val EMPOWER_OPTION_OBJECT = "option"
        const val EMPOWER_CONTENT_OBJECT = "content"
        const val INSTANCE_HASH_CODE = "instanceHashcode"

        @JvmStatic
        fun newInstance() = EmpowerFragment()
    }
}
