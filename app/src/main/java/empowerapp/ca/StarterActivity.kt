package empowerapp.ca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StarterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starter)

        findViewById<Button>(R.id.bt_with_xml).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.bt_with_compose).setOnClickListener {
            val intent = Intent(this, AppActivity::class.java)
            startActivity(intent)
        }
    }
}
