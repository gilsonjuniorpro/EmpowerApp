package empower.ca.ui

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import empower.ca.R
import empower.ca.fragment.DetailFragment


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // add custom back button
        val toolbar = findViewById<Toolbar>(R.id.action_detail_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setTitleTextColor(Color.WHITE)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.addToBackStack(null)
        transaction.replace(R.id.detail_container, DetailFragment()).commit()
    }
}
