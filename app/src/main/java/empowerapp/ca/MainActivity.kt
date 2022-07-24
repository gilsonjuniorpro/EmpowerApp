package empowerapp.ca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import empower.ca.core.Empower
import empower.ca.enums.ContentType
import empower.ca.model.Content
import empower.ca.model.ContentWrapper
import empower.ca.model.Operator
import empower.ca.sealed.Option
import empower.ca.sealed.Power
import empower.ca.util.Utils


class MainActivity : AppCompatActivity() {

    var contentList = ArrayList<Content>()
    var contentWrapper = ContentWrapper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.bt_load_ads).setOnClickListener {
            populate(Utils.contentTypeToString(ContentType.EMPOWER_VIEWTYPE_ADS))
            val container = Option.Container(
                "Este eh o titulo do ads",
                "ver mais"
            )
            loadData(Power.Ads, container)
        }

        findViewById<Button>(R.id.bt_load_basic).setOnClickListener {
            populate(Utils.contentTypeToString(ContentType.EMPOWER_VIEWTYPE_BASIC))
            val container = Option.Container(
                "Este eh o titulo do basic",
                "detalhes"
            )
            loadData(Power.Basic, container)
        }

        findViewById<Button>(R.id.bt_load_banner).setOnClickListener {
            populate(Utils.contentTypeToString(ContentType.EMPOWER_VIEWTYPE_BANNER))
            val container = Option.Container(
                "Este eh o titulo do banner",
                "share"
            )
            loadData(Power.Banner, container)
        }

        findViewById<Button>(R.id.bt_load_expose).setOnClickListener {
            populate(Utils.contentTypeToString(ContentType.EMPOWER_VIEWTYPE_EXPOSE))
            val container = Option.Container(
                "Este eh o titulo do expose",
                "ver todos"
            )
            loadData(Power.Expose, container)
        }
    }

    private fun loadData(power: Power, container: Option.Container?) {
        val transaction = supportFragmentManager.beginTransaction()

        Empower.fragment(
            applicationContext,
            Option.Container(container?.title, container?.linkText),
            power,
            contentWrapper
        ).let {
            transaction.replace(R.id.layout_base, it)
        }

        transaction.commit()
    }

    fun populate(contentType: String){
        contentList.clear()
        repeat((0..4).count()) {
            contentList.add(
                Content(
                    header = "Olaaaa infermeira",
                    title = "Este eh a porra do titulo",
                    description = "aqui esta a descricao do bagulho",
                    image = "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                    operators = listOf(
                        Operator(
                            type = "button",
                            actionType = "open detail",
                            actionValue= "",
                            text = "my button"
                        )
                    )
                )
            )
        }

        contentWrapper = ContentWrapper(
            contentType = contentType,
            contents = contentList
        )
    }
}
