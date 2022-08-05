package empower.ca.dto

import android.os.Parcelable
import empower.ca.dto.ContentDto
import empower.ca.enums.ContentType
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContentWrapperDto(
    var urlJson: String? = null,
    var containerTitle: String? = "",
    var contentType: String? = "",
    var contents: List<ContentDto> = ArrayList(),
    var layout: Int? = null
): Parcelable
