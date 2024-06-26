package empower.ca.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import empower.ca.databinding.ItemBaseBinding
import empower.ca.enums.ContentType
import empower.ca.dto.ContentDto
import empower.ca.dto.ContentWrapperDto
import empower.ca.sealed.Power
import empower.ca.util.extractContentType
import empower.ca.util.loadData


class EmpowerAdapter(private val power: Power?, private val contentWrapperDto: ContentWrapperDto?, private val layoutInflater: LayoutInflater) : ListAdapter<ContentDto,
        EmpowerAdapter.EmpowerViewHolder>(ContentCallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpowerViewHolder {
        return EmpowerViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: EmpowerViewHolder, position: Int) {
        holder.bind(power, getItem(position), contentWrapperDto, layoutInflater)
    }

    class EmpowerViewHolder private constructor(private val binding: ItemBaseBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(power: Power?, content: ContentDto, contentWrapperDto: ContentWrapperDto?, layoutInflater: LayoutInflater){

            when(power){
                is Power.Basic -> {
                    if(extractContentType(contentWrapperDto?.contentType) == ContentType.EMPOWER_VIEWTYPE_BASIC) {
                        val viewBase = binding.layItemBasic
                        viewBase.apply {
                            loadData(this, content, itemView)
                        }
                    }
                }
                is Power.Banner -> {
                    if(extractContentType(contentWrapperDto?.contentType) == ContentType.EMPOWER_VIEWTYPE_BANNER) {
                        val viewBase = binding.layItemBanner
                        viewBase.apply {
                            loadData(this, content, itemView)
                        }
                    }
                }
                is Power.Expose -> {
                    if(extractContentType(contentWrapperDto?.contentType) == ContentType.EMPOWER_VIEWTYPE_EXPOSE) {
                        val viewBase = binding.layItemExpose
                        viewBase.apply {
                            loadData(this, content, itemView)
                        }
                    }
                }
                is Power.Ads -> {
                    if(extractContentType(contentWrapperDto?.contentType) == ContentType.EMPOWER_VIEWTYPE_ADS) {
                        val viewBase = binding.layItemAds
                        viewBase.apply {
                            loadData(this, content, itemView)
                        }
                    }
                }
                is Power.Custom -> {
                    if(extractContentType(contentWrapperDto?.contentType) == ContentType.EMPOWER_VIEWTYPE_CUSTOM) {
                        val viewBase = binding.layItemCustom
                        viewBase.apply {
                            loadData(this, content, itemView, contentWrapperDto, layoutInflater)
                        }
                    }
                }

                null -> print("Error")
            }

            if (power is Power.Expose) {
                binding.layContainerBase.layoutParams =
                    ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT)
            }else{
                binding.layContainerBase.layoutParams =
                    ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT)
            }
        }

        companion object {
            fun from(parent: ViewGroup): EmpowerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemBaseBinding.inflate(layoutInflater, parent, false)
                return EmpowerViewHolder(binding)
            }
        }
    }
}

class ContentCallBack : DiffUtil.ItemCallback<ContentDto>(){
    override fun areItemsTheSame(oldItem: ContentDto, newItem: ContentDto): Boolean {
        return oldItem.header == newItem.header
    }

    override fun areContentsTheSame(oldItem: ContentDto, newItem: ContentDto): Boolean {
        return oldItem.header == newItem.header
    }
}
