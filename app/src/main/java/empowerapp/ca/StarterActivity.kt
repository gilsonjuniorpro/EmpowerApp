package empowerapp.ca

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class StarterActivity : AppCompatActivity() {

    val POST_NOTIFICATIONS_PERMISSION_CODE = 101

    fun hasNotificationsPermission(context: Context) =
        ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starter)

        if (!hasNotificationsPermission(applicationContext)) {
            makeRequest()
        }

        findViewById<Button>(R.id.bt_with_xml).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.bt_with_compose).setOnClickListener {
            val intent = Intent(this, AppActivity::class.java)
            startActivity(intent)
        }
    }

    private fun makeRequest() {
        val permissionsToRequest = mutableListOf<String>()

        if (!hasNotificationsPermission(applicationContext)) {
            permissionsToRequest.add(Manifest.permission.POST_NOTIFICATIONS)
        }

        if (permissionsToRequest.isNotEmpty()) {
            ActivityCompat.requestPermissions(
                this,
                permissionsToRequest.toTypedArray(),
                POST_NOTIFICATIONS_PERMISSION_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == POST_NOTIFICATIONS_PERMISSION_CODE && grantResults.isNotEmpty()) {
            for (i in grantResults.indices) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "PERMISSION GRANTED", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
