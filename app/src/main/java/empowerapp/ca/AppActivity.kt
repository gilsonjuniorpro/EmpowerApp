package empowerapp.ca

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

private const val ADS = "ads"

class AppActivity : AppCompatActivity() {
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
                        View.inflate(context, R.layout.activity_main, null)
                    },
                    update = {
                        (context as AppCompatActivity).let {
                            val transaction = context.supportFragmentManager.beginTransaction()
                            Empower.fragment(
                                applicationContext,
                                Option.Container("This is the $ADS", "just go"),
                                Power.Banner
                            ).let {
                                transaction.replace(R.id.layout_base, it)
                            }
                            transaction.commit()
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EmpowerTheme {
        Greeting("Android")
    }
}

