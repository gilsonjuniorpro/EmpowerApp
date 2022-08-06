package empower.ca.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import empower.ca.R
import empower.ca.databinding.*
import empower.ca.dto.ContentDto
import empower.ca.dto.ContentWrapperDto
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

fun loadData(view: ItemCustomBinding, content: ContentDto, itemView: View, contentWrapperDto: ContentWrapperDto?, layoutInflater: LayoutInflater) {
    view.cardCustom.visibility = View.VISIBLE
    val myView = layoutInflater.inflate(contentWrapperDto?.layout!!, null)
    view.cardCustom.addView(myView)

    val image = myView.findViewById<ImageView>(R.id.image)
    val header = myView.findViewById<TextView>(R.id.header)
    val title = myView.findViewById<TextView>(R.id.title)
    val description = myView.findViewById<TextView>(R.id.description)
    val buttonOperator = myView.findViewById<Button>(R.id.button_operator)
    val linkOperator = myView.findViewById<TextView>(R.id.link_operator)

    header.text = content.header
    title.text = content.title
    description.text = content.description
    buttonOperator.visibility = View.GONE
    linkOperator.visibility = View.GONE

    var url: String? = null
    for (op in content.operators) {
        if (op.type == "button") {
            buttonOperator.text = op.text
            buttonOperator.visibility = View.VISIBLE
        }
        if (op.type == "link") {
            linkOperator.text = op.text
            linkOperator.visibility = View.VISIBLE
            url = op.actionValue
        }
    }

    Glide.with(itemView)
        .load(content.image)
        .centerCrop()
        .transition(DrawableTransitionOptions.withCrossFade())
        .error(R.drawable.marvel)
        .into(image)

    buttonOperator.setOnClickListener {
        openDetail(view.cardCustom.context, content, url)
    }
    linkOperator.setOnClickListener {
        openDetail(view.cardCustom.context, content, url)
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
