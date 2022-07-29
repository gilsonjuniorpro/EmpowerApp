package empower.ca.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import empower.ca.R
import empower.ca.dto.ContentDto


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val content = intent.getParcelableExtra<ContentDto>("content")

        val header = findViewById<TextView>(R.id.header)
        val title = findViewById<TextView>(R.id.title)
        val description = findViewById<TextView>(R.id.description)
        val image = findViewById<ImageView>(R.id.image)

        content?.let {
            header.text = it.header
            title.text = it.title
            description.text = it.description

            Glide.with(image)
                .load(it.image)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .error(R.drawable.marvel)
                .into(image)
        }

    }
}
