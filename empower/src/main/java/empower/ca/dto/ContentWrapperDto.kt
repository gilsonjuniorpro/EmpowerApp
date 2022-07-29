package empower.ca.dto

import android.os.Parcelable
import empower.ca.dto.ContentDto
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContentWrapperDto(
    var urlJson: String = "",
    var containerTitle: String = "",
    var contentType: String = "EMPOWER_VIEWTYPE_BASIC",
    var contents: List<ContentDto> = ArrayList()
): Parcelable
