package empower.ca.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import empower.ca.R
import empower.ca.adapter.EmpowerAdapter
import empower.ca.databinding.FragmentEmpowerBinding
import empower.ca.dto.ContentDto
import empower.ca.dto.ContentWrapperDto
import empower.ca.repository.EmpowerRepository
import empower.ca.sealed.Option
import empower.ca.sealed.Power
import empower.ca.util.URL_BASE
import empower.ca.util.getOption
import empower.ca.util.getPower
import empower.ca.viewmodel.EmpowerViewModel
import empower.ca.viewmodel.EmpowerViewModelFactory

/**
 * A simple [Fragment] subclass.
 * Use the [EmpowerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EmpowerFragment : Fragment() {

    private var power: Power? = null
    private var option: Option.Container? = null
    private var instanceHashCode: Int = 0
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var empowerAdapter: EmpowerAdapter
    lateinit var binding: FragmentEmpowerBinding

    private val viewModel: EmpowerViewModel by lazy {
        ViewModelProvider(
            this,
            EmpowerViewModelFactory(
                EmpowerRepository(requireContext())
            )
        )[EmpowerViewModel::class.java]
    }

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

            var contentWrapper: ContentWrapperDto =
                arguments?.getParcelable(EMPOWER_CONTENT_OBJECT) ?: ContentWrapperDto()


            if(contentWrapper.urlJson != null){
                val url = "$URL_BASE${contentWrapper.urlJson}"
                viewModel.getJson(url)
            }else{
                viewModel.setContentWrapperState(contentWrapper)
            }

            linearLayoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

            viewModel.state.observe(viewLifecycleOwner) { state ->
                when (state) {
                    is EmpowerViewModel.State.Loading -> {
                        binding.loading.loadindContainer.visibility = View.VISIBLE
                    }

                    is EmpowerViewModel.State.Loaded -> {
                        binding.loading.loadindContainer.visibility = View.GONE
                        contentWrapper = state.contentWrapperDto ?: ContentWrapperDto()

                        //option = arguments?.getParcelable<Option.Container>(EMPOWER_OPTION_OBJECT)
                        option = getOption(contentWrapper.containerTitle)

                        //power = arguments?.getParcelable<Power>(EMPOWER_POWER_OBJECT)
                        power = getPower(contentWrapper.contentType)

                        if (!option?.title.isNullOrEmpty() || !option?.linkText.isNullOrEmpty()) {
                            option?.title?.let {
                                binding.containerTitle.text = option?.title
                                binding.containerTitle.visibility = View.VISIBLE
                            }

                            option?.linkText?.let {
                                binding.containerAction.text = option?.linkText
                                binding.containerAction.visibility = View.VISIBLE
                            }
                        } else {
                            if(!contentWrapper.containerTitle.isNullOrEmpty()){
                                binding.containerTitle.text = contentWrapper.containerTitle
                                binding.containerTitle.visibility = View.VISIBLE
                            }else{
                                binding.titleLinkContainer.visibility = View.GONE
                            }
                        }

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

                    is EmpowerViewModel.State.Error -> {
                        binding.loading.loadindContainer.visibility = View.GONE
                        if (!state.hasConsumed) {
                            state.hasConsumed = true
                            Toast.makeText(
                                requireContext(),
                                R.string.error_loading,
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }
    }

    private fun initAdapter(contentType: String?) {
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

    private fun handleData(list: List<ContentDto>) {
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
