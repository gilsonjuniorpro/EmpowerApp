package empower.ca.adapter

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import empower.ca.R
import empower.ca.databinding.ItemBannerBinding
import empower.ca.databinding.ItemBaseBinding
import empower.ca.model.Content
import empower.ca.sealed.Power


class EmpowerAdapter(private val power: Power, private val clickListener: ContentListener) : ListAdapter<Content,
        EmpowerAdapter.EmpowerViewHolder>(ContentCallBack()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmpowerViewHolder {
        return EmpowerViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: EmpowerViewHolder, position: Int) {
        holder.bind(power, clickListener, getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    class EmpowerViewHolder private constructor(private val binding: ItemBaseBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(power: Power, clickListener: ContentListener, content: Content){

            when(power){
                is Power.Basic -> {
                    if(content.contentType == "basic") {
                        val viewBase = binding.layItemBasic
                        viewBase.apply {
                            cardBasic.visibility = View.VISIBLE
                            header.text = content.header
                            title.text = content.title
                            description.text = content.description
                            buttonOperator.visibility = View.GONE
                            linkOperator.visibility = View.GONE

                            for(op in content.operators){
                                if(op.type == "button"){
                                    buttonOperator.text = op.text
                                    buttonOperator.visibility = View.VISIBLE
                                }
                                if(op.type == "link"){
                                    linkOperator.text = op.text
                                    linkOperator.visibility = View.VISIBLE
                                }
                            }

                            Glide.with(itemView)
                                .load(content.image)
                                .centerCrop()
                                .transition(DrawableTransitionOptions.withCrossFade())
                                .error(R.drawable.marvel)
                                .into(image)
                        }
                    }
                }
                is Power.Banner -> {
                    if(content.contentType == "banner") {
                        val viewBase = binding.layItemBanner
                        viewBase.apply {
                            cardBanner.visibility = View.VISIBLE
                            header.text = content.header
                            title.text = content.title
                            description.text = content.description
                            buttonOperator.visibility = View.GONE
                            linkOperator.visibility = View.GONE

                            for(op in content.operators){
                                if(op.type == "button"){
                                    buttonOperator.text = op.text
                                    buttonOperator.visibility = View.VISIBLE
                                }
                                if(op.type == "link"){
                                    linkOperator.text = op.text
                                    linkOperator.visibility = View.VISIBLE
                                }
                            }

                            Glide.with(itemView)
                                .load(content.image)
                                .centerCrop()
                                .transition(DrawableTransitionOptions.withCrossFade())
                                .error(R.drawable.marvel)
                                .into(image)
                        }
                    }
                }
                is Power.Expose -> {
                    if(content.contentType == "expose") {
                        val viewBase = binding.layItemExpose
                        viewBase.apply {
                            cardExpose.visibility = View.VISIBLE
                            header.text = content.header
                            title.text = content.title
                            description.text = content.description
                            buttonOperator.visibility = View.GONE
                            linkOperator.visibility = View.GONE

                            for(op in content.operators){
                                if(op.type == "button"){
                                    buttonOperator.text = op.text
                                    buttonOperator.visibility = View.VISIBLE
                                }
                                if(op.type == "link"){
                                    linkOperator.text = op.text
                                    linkOperator.visibility = View.VISIBLE
                                }
                            }

                            Glide.with(itemView)
                                .load(content.image)
                                .centerCrop()
                                .transition(DrawableTransitionOptions.withCrossFade())
                                .error(R.drawable.marvel)
                                .into(image)
                        }
                    }
                }
                is Power.Ads -> {
                    if(content.contentType == "ads") {
                        val viewBase = binding.layItemAds
                        viewBase.apply {
                            cardAds.visibility = View.VISIBLE
                            header.text = content.header
                            title.text = content.title
                            description.text = content.description
                            buttonOperator.visibility = View.GONE
                            linkOperator.visibility = View.GONE

                            for(op in content.operators){
                                if(op.type == "button"){
                                    buttonOperator.text = op.text
                                    buttonOperator.visibility = View.VISIBLE
                                }
                                if(op.type == "link"){
                                    linkOperator.text = op.text
                                    linkOperator.visibility = View.VISIBLE
                                }
                            }

                            Glide.with(itemView)
                                .load(content.image)
                                .centerCrop()
                                .transition(DrawableTransitionOptions.withCrossFade())
                                .error(R.drawable.marvel)
                                .into(image)
                        }
                    }
                }
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

class ContentCallBack : DiffUtil.ItemCallback<Content>(){
    override fun areItemsTheSame(oldItem: Content, newItem: Content): Boolean {
        return oldItem.header == newItem.header
    }

    override fun areContentsTheSame(oldItem: Content, newItem: Content): Boolean {
        return oldItem.header == newItem.header
    }
}

class ContentListener(val clickListener: (content: Content) -> Unit) {
    fun onClick(content: Content) = clickListener(content)
}
