package empower.ca.util

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
        Toast.makeText(view.cardBasic.context, "button", Toast.LENGTH_LONG).show()
    }
    view.linkOperator.setOnClickListener {
        Toast.makeText(view.cardBasic.context, "link", Toast.LENGTH_LONG).show()
    }
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
        Toast.makeText(view.cardBanner.context, "button", Toast.LENGTH_LONG).show()
    }
    view.linkOperator.setOnClickListener {
        Toast.makeText(view.cardBanner.context, "link", Toast.LENGTH_LONG).show()
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
        Toast.makeText(view.cardExpose.context, "button", Toast.LENGTH_LONG).show()
    }
    view.linkOperator.setOnClickListener {
        Toast.makeText(view.cardExpose.context, "link", Toast.LENGTH_LONG).show()
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
        Toast.makeText(view.cardAds.context, "button", Toast.LENGTH_LONG).show()
    }
    view.linkOperator.setOnClickListener {
        Toast.makeText(view.cardAds.context, "link", Toast.LENGTH_LONG).show()
    }
}
