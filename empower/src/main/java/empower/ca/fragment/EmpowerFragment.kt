package empower.ca.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import empower.ca.adapter.EmpowerAdapter
import empower.ca.databinding.FragmentEmpowerBinding
import empower.ca.model.Content
import empower.ca.sealed.Option
import empower.ca.sealed.Power
import empower.ca.viewmodel.ContentViewModel

/**
 * A simple [Fragment] subclass.
 * Use the [EmpowerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EmpowerFragment : Fragment() {

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

            val option = arguments?.getParcelable(EMPOWER_OPTION_OBJECT) ?: Option.Container()
            option.let {
                binding.containerTitle.text = option.title
                binding.containerAction.text = option.linkText
                binding.containerTitle.visibility = View.VISIBLE
                binding.containerAction.visibility = View.VISIBLE
            }

            val power = arguments?.getParcelable<Power>(EMPOWER_POWER_OBJECT) ?: Power.Basic

            linearLayoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            if (power is Power.Banner || power is Power.Expose) {
                linearLayoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            }

            initAdapter(power)

            viewModel.listContent(power)
        }
    }

    private fun initAdapter(power: Power) {
        empowerAdapter = EmpowerAdapter(power)

        with(binding.feedRecycler) {
            layoutManager = linearLayoutManager
            setHasFixedSize(true)
            adapter = empowerAdapter
            smoothScrollToPosition(0)

            val pager = PagerSnapHelper()
            pager.attachToRecyclerView(this)
        }

        viewModel.content.observe(viewLifecycleOwner) { list ->
            empowerAdapter.submitList(list)

            if (power is Power.Banner) {
                binding.indicatorView.apply {
                    visibility = View.VISIBLE
                    setRecyclerView(
                        binding.feedRecycler, linearLayoutManager, list.size,
                        linearLayoutManager?.findLastVisibleItemPosition(), false
                    )
                }
            } else {
                binding.indicatorView.apply {
                    visibility = View.GONE
                }
            }
        }
    }

    companion object {
        const val EMPOWER_POWER_OBJECT = "power"
        const val EMPOWER_OPTION_OBJECT = "option"
        const val INSTANCE_HASH_CODE = "instanceHashcode"

        @JvmStatic
        fun newInstance() = EmpowerFragment()
    }
}
