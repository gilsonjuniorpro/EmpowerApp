package empower.ca.util

import empower.ca.enums.ContentType
import empower.ca.sealed.Option
import empower.ca.sealed.Power

fun extractContentType(contentType: String?): ContentType {
    return when (contentType) {
        "EMPOWER_VIEWTYPE_BASIC" -> {
            ContentType.EMPOWER_VIEWTYPE_BASIC
        }
        "EMPOWER_VIEWTYPE_BANNER" -> {
            ContentType.EMPOWER_VIEWTYPE_BANNER
        }
        "EMPOWER_VIEWTYPE_ADS" -> {
            ContentType.EMPOWER_VIEWTYPE_ADS
        }
        "EMPOWER_VIEWTYPE_EXPOSE" -> {
            ContentType.EMPOWER_VIEWTYPE_EXPOSE
        }
        else -> {
            ContentType.EMPOWER_VIEWTYPE_CUSTOM
        }
    }
}

fun contentTypeToString(contentType: ContentType): String {
    return when (contentType) {
        ContentType.EMPOWER_VIEWTYPE_BASIC -> {
            "EMPOWER_VIEWTYPE_BASIC"
        }
        ContentType.EMPOWER_VIEWTYPE_BANNER -> {
            "EMPOWER_VIEWTYPE_BANNER"
        }
        ContentType.EMPOWER_VIEWTYPE_ADS -> {
            "EMPOWER_VIEWTYPE_ADS"
        }
        ContentType.EMPOWER_VIEWTYPE_EXPOSE -> {
            "EMPOWER_VIEWTYPE_EXPOSE"
        }
        else -> {
            "EMPOWER_VIEWTYPE_CUSTOM"
        }
    }
}

fun getPower(contentType: String?): Power {
    return when (contentType) {
        "EMPOWER_VIEWTYPE_BASIC" -> {
            Power.Basic
        }
        "EMPOWER_VIEWTYPE_BANNER" -> {
            Power.Banner
        }
        "EMPOWER_VIEWTYPE_ADS" -> {
            Power.Ads
        }
        "EMPOWER_VIEWTYPE_EXPOSE" -> {
            Power.Expose
        }
        else -> {
            Power.Custom
        }
    }
}

fun getOption(containerTitle: String?): Option.Container {
    return Option.Container(containerTitle)
}
