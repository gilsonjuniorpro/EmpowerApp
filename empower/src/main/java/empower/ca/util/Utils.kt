package empower.ca.util

import empower.ca.enums.ContentType

object Utils {

    fun extractContentType(contentType: String): ContentType {
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
            else -> {
                ContentType.EMPOWER_VIEWTYPE_EXPOSE
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
            else -> {
                "EMPOWER_VIEWTYPE_EXPOSE"
            }
        }
    }

}