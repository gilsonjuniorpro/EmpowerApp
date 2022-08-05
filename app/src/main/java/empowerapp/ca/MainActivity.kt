package empowerapp.ca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import empower.ca.core.Empower
import empower.ca.enums.ContentType
import empower.ca.dto.ContentDto
import empower.ca.dto.ContentWrapperDto
import empower.ca.dto.OperatorDto
import empower.ca.sealed.Option
import empower.ca.sealed.Power
import empower.ca.util.URL_BASE
import empower.ca.util.contentTypeToString


class MainActivity : AppCompatActivity() {

    var contentList = ArrayList<ContentDto>()
    var contentWrapper = ContentWrapperDto()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.bt_load_ads_from_url).setOnClickListener {
            contentWrapper = ContentWrapperDto(
                urlJson = URL_BASE,
                containerTitle = "this is the title ADS",
                contentType = contentTypeToString(ContentType.EMPOWER_VIEWTYPE_ADS)
            )
            loadDataFromUrl(contentWrapper)
        }

        findViewById<Button>(R.id.bt_load_basic_from_url).setOnClickListener {
            contentWrapper = ContentWrapperDto(
                urlJson = URL_BASE,
                containerTitle = "this is the title BASIC",
                contentType = contentTypeToString(ContentType.EMPOWER_VIEWTYPE_BASIC)
            )
            loadDataFromUrl(contentWrapper)
        }

        findViewById<Button>(R.id.bt_load_banner_from_url).setOnClickListener {
            contentWrapper = ContentWrapperDto(
                urlJson = URL_BASE,
                containerTitle = "this is the title BANNER",
                contentType = contentTypeToString(ContentType.EMPOWER_VIEWTYPE_BANNER)
            )
            loadDataFromUrl(contentWrapper)
        }

        findViewById<Button>(R.id.bt_load_expose_from_url).setOnClickListener {
            contentWrapper = ContentWrapperDto(
                urlJson = URL_BASE,
                containerTitle = "this is the title EXPOSE",
                contentType = contentTypeToString(ContentType.EMPOWER_VIEWTYPE_EXPOSE)
            )
            loadDataFromUrl(contentWrapper)
        }

        findViewById<Button>(R.id.bt_load_ads).setOnClickListener {
            populate(contentTypeToString(ContentType.EMPOWER_VIEWTYPE_ADS))
            val container = Option.Container(
                "Este eh o titulo do ads",
                "ver mais"
            )
            loadDataWithParams(Power.Ads, container)
        }

        findViewById<Button>(R.id.bt_load_basic).setOnClickListener {
            populate(contentTypeToString(ContentType.EMPOWER_VIEWTYPE_BASIC))
            val container = Option.Container(
                "Este eh o titulo do basic",
                "detalhes"
            )
            loadDataWithParams(Power.Basic, container)
        }

        findViewById<Button>(R.id.bt_load_banner).setOnClickListener {
            populate(contentTypeToString(ContentType.EMPOWER_VIEWTYPE_BANNER))
            val container = Option.Container(
                "Este eh o titulo do banner",
                "share"
            )
            loadDataWithParams(Power.Banner, container)
        }

        findViewById<Button>(R.id.bt_load_expose).setOnClickListener {
            populate(contentTypeToString(ContentType.EMPOWER_VIEWTYPE_EXPOSE))
            val container = Option.Container(
                "",
                ""
            )
            loadDataWithParams(Power.Expose, container)
        }

        findViewById<Button>(R.id.bt_load_custom).setOnClickListener {
            populateCustom(contentTypeToString(ContentType.EMPOWER_VIEWTYPE_CUSTOM))
            val container = Option.Container(
                "",
                ""
            )
            loadDataWithParams(Power.Custom, container)
        }
    }

    private fun loadDataFromUrl(dto: ContentWrapperDto) {
        val transaction = supportFragmentManager.beginTransaction()

        Empower.fragment(
            dto
        ).let {
            transaction.replace(R.id.layout_base, it)
        }

        transaction.commit()
    }

    private fun loadDataWithParams(power: Power, container: Option.Container?) {
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

    private fun loadData() {
        val transaction = supportFragmentManager.beginTransaction()

        Empower.fragment(
            contentWrapper
        ).let {
            transaction.replace(R.id.layout_base, it)
        }

        transaction.commit()
    }

    private fun populate(contentType: String?) {
        contentList.clear()

        contentList.add(
            ContentDto(
                header = "Olaaaa infermeira",
                title = "Este eh a porra do titulo",
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                image = "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                operators = listOf(
                    OperatorDto(
                        type = "link",
                        actionType = "open detail",
                        actionValue = "https://investnews.com.br/cafeina/19-fundos-imobiliarios-com-rendimentos-acima-de-1325-ao-ano/",
                        text = "my button"
                    )
                )
            )
        )

        repeat((0..4).count()) {
            contentList.add(
                ContentDto(
                    header = "Olaaaa infermeira",
                    title = "Este eh a porra do titulo",
                    description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    image = "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                    operators = listOf(
                        OperatorDto(
                            type = "button",
                            actionType = "open detail",
                            actionValue = "https://investnews.com.br/cafeina/19-fundos-imobiliarios-com-rendimentos-acima-de-1325-ao-ano/",
                            text = "my button"
                        )
                    )
                )
            )
        }

        /*
        contentWrapper = ContentWrapperDto(
            urlJson = "https://www.projectconnect.com.br/send_notification/api/component/list/list.php",
            containerTitle = "this is the title",
            contentType = contentType,
            contents = contentList
        )
        */

        contentWrapper = ContentWrapperDto(
            contentType = contentType,
            contents = contentList
        )
    }

    private fun populateCustom(contentType: String?) {
        contentList.clear()

        contentList.add(
            ContentDto(
                header = "Olaaaa infermeira",
                title = "Este eh a porra do titulo",
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                image = "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                operators = listOf(
                    OperatorDto(
                        type = "link",
                        actionType = "open detail",
                        actionValue = "https://investnews.com.br/cafeina/19-fundos-imobiliarios-com-rendimentos-acima-de-1325-ao-ano/",
                        text = "my button"
                    )
                )
            )
        )

        repeat((0..4).count()) {
            contentList.add(
                ContentDto(
                    header = "Olaaaa infermeira",
                    title = "Este eh a porra do titulo",
                    description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    image = "https://cdn.britannica.com/49/182849-050-4C7FE34F/scene-Iron-Man.jpg",
                    operators = listOf(
                        OperatorDto(
                            type = "button",
                            actionType = "open detail",
                            actionValue = "https://investnews.com.br/cafeina/19-fundos-imobiliarios-com-rendimentos-acima-de-1325-ao-ano/",
                            text = "my button"
                        )
                    )
                )
            )
        }

        /*
        contentWrapper = ContentWrapperDto(
            urlJson = "https://www.projectconnect.com.br/send_notification/api/component/list/list.php",
            containerTitle = "this is the title",
            contentType = contentType,
            contents = contentList
        )
        */

        contentWrapper = ContentWrapperDto(
            contentType = contentType,
            contents = contentList,
            layout = R.layout.item_custom_client
        )
    }
}
