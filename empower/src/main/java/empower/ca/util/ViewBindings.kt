package empower.ca.util

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import empower.ca.R
import empower.ca.databinding.ItemAdsBinding
import empower.ca.databinding.ItemBannerBinding
import empower.ca.databinding.ItemBasicBinding
import empower.ca.databinding.ItemExposeBinding
import empower.ca.model.Content
import empower.ca.ui.DetailActivity


fun loadData(view: ItemBasicBinding, content: Content, itemView: View) {
    view.cardBasic.visibility = View.VISIBLE
    view.header.text = content.header
    view.title.text = content.title
    view.description.text = content.description
    view.buttonOperator.visibility = View.GONE
    view.linkOperator.visibility = View.GONE

    for (op in content.operators) {
        if (op.type == "button") {
            view.buttonOperator.text = op.text
            view.buttonOperator.visibility = View.VISIBLE
        }
        if (op.type == "link") {
            view.linkOperator.text = op.text
            view.linkOperator.visibility = View.VISIBLE
        }
    }

    Glide.with(itemView)
        .load(content.image)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade())
        .error(R.drawable.marvel)
        .into(view.image)

    view.buttonOperator.setOnClickListener {
        openDetail(view.cardBasic.context, "button")
    }
    view.linkOperator.setOnClickListener {
        openDetail(view.cardBasic.context, "link")
    }
}

private fun openDetail(context: Context, itemCliked: String) {
    Toast.makeText(context, "$itemCliked", Toast.LENGTH_LONG).show()
    val intent = Intent(context, DetailActivity::class.java)
    context.startActivity(intent)
    /*val bundle = Bundle()
    bundle.putParcelable(
        ButtonCardDetailActivity.EXTRA_BUTTONCARD_DETAILS
    )
    bundle.putParcelable(
        ButtonCardDetailActivity.EXTRA_USER_ACTION_HANDLER,
        this
    )
    intent.openActivity(ButtonCardDetailActivity::class.java, bundle)*/
}

fun loadData(view: ItemBannerBinding, content: Content, itemView: View) {
    view.cardBanner.visibility = View.VISIBLE
    view.header.text = content.header
    view.title.text = content.title
    view.description.text = content.description
    view.buttonOperator.visibility = View.GONE
    view.linkOperator.visibility = View.GONE

    for (op in content.operators) {
        if (op.type == "button") {
            view.buttonOperator.text = op.text
            view.buttonOperator.visibility = View.VISIBLE
        }
        if (op.type == "link") {
            view.linkOperator.text = op.text
            view.linkOperator.visibility = View.VISIBLE
        }
    }

    Glide.with(itemView)
        .load(content.image)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade())
        .error(R.drawable.marvel)
        .into(view.image)

    view.buttonOperator.setOnClickListener {
        openDetail(view.cardBanner.context, "button")
    }
    view.linkOperator.setOnClickListener {
        openDetail(view.cardBanner.context, "link")
    }
}

fun loadData(view: ItemExposeBinding, content: Content, itemView: View) {
    view.cardExpose.visibility = View.VISIBLE
    view.header.text = content.header
    view.title.text = content.title
    view.description.text = content.description
    view.buttonOperator.visibility = View.GONE
    view.linkOperator.visibility = View.GONE

    for (op in content.operators) {
        if (op.type == "button") {
            view.buttonOperator.text = op.text
            view.buttonOperator.visibility = View.VISIBLE
        }
        if (op.type == "link") {
            view.linkOperator.text = op.text
            view.linkOperator.visibility = View.VISIBLE
        }
    }

    Glide.with(itemView)
        .load(content.image)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade())
        .error(R.drawable.marvel)
        .into(view.image)

    view.buttonOperator.setOnClickListener {
        openDetail(view.cardExpose.context, "button")
    }
    view.linkOperator.setOnClickListener {
        openDetail(view.cardExpose.context, "link")
    }
}

fun loadData(view: ItemAdsBinding, content: Content, itemView: View) {
    view.cardAds.visibility = View.VISIBLE
    view.header.text = content.header
    view.title.text = content.title
    view.description.text = content.description
    view.buttonOperator.visibility = View.GONE
    view.linkOperator.visibility = View.GONE

    for (op in content.operators) {
        if (op.type == "button") {
            view.buttonOperator.text = op.text
            view.buttonOperator.visibility = View.VISIBLE
        }
        if (op.type == "link") {
            view.linkOperator.text = op.text
            view.linkOperator.visibility = View.VISIBLE
        }
    }

    Glide.with(itemView)
        .load(content.image)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade())
        .error(R.drawable.marvel)
        .into(view.image)

    view.buttonOperator.setOnClickListener {
        openDetail(view.cardAds.context, "button")
    }
    view.linkOperator.setOnClickListener {
        openDetail(view.cardAds.context, "link")
    }
}
