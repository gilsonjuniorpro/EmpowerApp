package empower.ca.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContentWrapper(
    var title: String = "",
    var body: String = "",
    var contentType: String = "EMPOWER_VIEWTYPE_BASIC",
    var contents: List<Content> = ArrayList()
): Parcelable
