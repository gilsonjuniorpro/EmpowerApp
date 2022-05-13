package empowerapp.ca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import empower.ca.core.Empower
import empower.ca.sealed.Option
import empower.ca.sealed.Power

private const val ADS = "ads"
private const val BASIC = "basic"
private const val BANNER = "banner"
private const val EXPOSE = "expose"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.bt_load_ads).setOnClickListener {
            loadData(ADS)
        }

        findViewById<Button>(R.id.bt_load_basic).setOnClickListener {
            loadData(BASIC)
        }

        findViewById<Button>(R.id.bt_load_banner).setOnClickListener {
            loadData(BANNER)
        }

        findViewById<Button>(R.id.bt_load_expose).setOnClickListener {
            loadData(EXPOSE)
        }
    }

    private fun loadData(what: String) {
        val transaction = supportFragmentManager.beginTransaction()

        when(what) {
            ADS -> {
                Empower.fragment(
                    applicationContext,
                    Option.Container("This is the $ADS", "just go"),
                    Power.Ads
                ).let {
                    transaction.replace(R.id.layout_base, it)
                }
            }
            BASIC -> {
                Empower.fragment(
                    applicationContext,
                    Option.Container("This is the $BASIC", "just go"),
                    Power.Basic
                ).let {
                    transaction.replace(R.id.layout_base, it)
                }
            }
            BANNER -> {
                Empower.fragment(
                    applicationContext,
                    Option.Container("This is the $BANNER", "just go"),
                    Power.Banner
                ).let {
                    transaction.replace(R.id.layout_base, it)
                }
            }
            EXPOSE -> {
                Empower.fragment(
                    applicationContext,
                    Option.Container("This is the $EXPOSE", "just go"),
                    Power.Expose
                ).let {
                    transaction.replace(R.id.layout_base, it)
                }
            }
        }

        transaction.commit()
    }
}
