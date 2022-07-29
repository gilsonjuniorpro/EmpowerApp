package empower.ca.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ContentDto(
    var header: String?,
    var title: String?,
    var description: String?,
    var image: String?,
    var operators: List<OperatorDto>
): Parcelable
