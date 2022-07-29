package empower.ca.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import empower.ca.R
import empower.ca.databinding.ItemAdsBinding
import empower.ca.databinding.ItemBannerBinding
import empower.ca.databinding.ItemBasicBinding
import empower.ca.databinding.ItemExposeBinding
import empower.ca.dto.ContentDto
import empower.ca.ui.DetailActivity


fun loadData(view: ItemBasicBinding, content: ContentDto, itemView: View) {
    view.cardBasic.visibility = View.VISIBLE
    view.header.text = content.header
    view.title.text = content.title
    view.description.text = content.description
    view.buttonOperator.visibility = View.GONE
    view.linkOperator.visibility = View.GONE

    var url: String? = null
    for (op in content.operators) {
        if (op.type == "button") {
            view.buttonOperator.text = op.text
            view.buttonOperator.visibility = View.VISIBLE
        }
        if (op.type == "link") {
            view.linkOperator.text = op.text
            view.linkOperator.visibility = View.VISIBLE
            url = op.actionValue
        }
    }

    Glide.with(itemView)
        .load(content.image)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade())
        .error(R.drawable.marvel)
        .into(view.image)

    view.buttonOperator.setOnClickListener {
        openDetail(view.cardBasic.context, content, url)
    }
    view.linkOperator.setOnClickListener {
        openDetail(view.cardBasic.context, content, url)
    }
}

fun loadData(view: ItemBannerBinding, content: ContentDto, itemView: View) {
    view.cardBanner.visibility = View.VISIBLE
    view.header.text = content.header
    view.title.text = content.title
    view.description.text = content.description
    view.buttonOperator.visibility = View.GONE
    view.linkOperator.visibility = View.GONE

    var url: String? = null
    for (op in content.operators) {
        if (op.type == "button") {
            view.buttonOperator.text = op.text
            view.buttonOperator.visibility = View.VISIBLE
        }
        if (op.type == "link") {
            view.linkOperator.text = op.text
            view.linkOperator.visibility = View.VISIBLE
            url = op.actionValue
        }
    }

    Glide.with(itemView)
        .load(content.image)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade())
        .error(R.drawable.marvel)
        .into(view.image)

    view.buttonOperator.setOnClickListener {
        openDetail(view.cardBanner.context, content, url)
    }
    view.linkOperator.setOnClickListener {
        openDetail(view.cardBanner.context, content, url)
    }
}

fun loadData(view: ItemExposeBinding, content: ContentDto, itemView: View) {
    view.cardExpose.visibility = View.VISIBLE
    view.header.text = content.header
    view.title.text = content.title
    view.description.text = content.description
    view.buttonOperator.visibility = View.GONE
    view.linkOperator.visibility = View.GONE

    var url: String? = null
    for (op in content.operators) {
        if (op.type == "button") {
            view.buttonOperator.text = op.text
            view.buttonOperator.visibility = View.VISIBLE
        }
        if (op.type == "link") {
            view.linkOperator.text = op.text
            view.linkOperator.visibility = View.VISIBLE
            url = op.actionValue
        }
    }

    Glide.with(itemView)
        .load(content.image)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade())
        .error(R.drawable.marvel)
        .into(view.image)

    view.buttonOperator.setOnClickListener {
        openDetail(view.cardExpose.context, content, url)
    }
    view.linkOperator.setOnClickListener {
        openDetail(view.cardExpose.context, content, url)
    }
}

fun loadData(view: ItemAdsBinding, content: ContentDto, itemView: View) {
    view.cardAds.visibility = View.VISIBLE
    view.header.text = content.header
    view.title.text = content.title
    view.description.text = content.description
    view.buttonOperator.visibility = View.GONE
    view.linkOperator.visibility = View.GONE

    var url: String? = null
    for (op in content.operators) {
        if (op.type == "button") {
            view.buttonOperator.text = op.text
            view.buttonOperator.visibility = View.VISIBLE
        }
        if (op.type == "link") {
            view.linkOperator.text = op.text
            view.linkOperator.visibility = View.VISIBLE
            url = op.actionValue
        }
    }

    Glide.with(itemView)
        .load(content.image)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade())
        .error(R.drawable.marvel)
        .into(view.image)

    view.buttonOperator.setOnClickListener {
        openDetail(view.cardAds.context, content, url)
    }
    view.linkOperator.setOnClickListener {
        openDetail(view.cardAds.context, content, url)
    }
}

private fun openDetail(context: Context, content: ContentDto, url: String? = null) {
    if(url != null){
        val openURL = Intent(Intent.ACTION_VIEW)
        openURL.data = Uri.parse(url)
        context.startActivity(openURL)
    }else{
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("content", content)
        context.startActivity(intent)
    }
}
