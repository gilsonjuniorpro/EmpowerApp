package empowerapp.ca

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.FragmentContainer
import empower.ca.core.Empower
import empower.ca.sealed.Option
import empower.ca.sealed.Power
import empowerapp.ca.ui.theme.EmpowerTheme
import org.w3c.dom.Text

private const val ADS = "ads"
private const val BASIC = "basic"
private const val BANNER = "banner"
private const val EXPOSE = "expose"

class AppActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmpowerTheme {
                /*Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }*/
                /*val frag = Empower.fragment(
                    applicationContext,
                    Option.Container("This is the $ADS", "just go"),
                    Power.Ads
                )*/

                val context = LocalContext.current

                AndroidView(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    factory = { context ->
                        //View.inflate(context, R.layout.activity_main, null)
                        FrameLayout(context).apply {
                            id = 9999999
                        }
                    },
                    update = {
                        (context as AppCompatActivity).let {
                            val transaction = context.supportFragmentManager.beginTransaction()
                            Empower.fragment(
                                applicationContext,
                                Option.Container(title = "This is the $BASIC", linkText = "just go"),
                                Power.Basic
                            ).let {
                                transaction.replace(9999999, it)
                            }
                            transaction.commit()
                        }
                    }
                )
            }
        }
    }
}
