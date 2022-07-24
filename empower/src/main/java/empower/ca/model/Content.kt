package empower.ca.model

import android.os.Parcelable
import empower.ca.enums.ContentType
import kotlinx.parcelize.Parcelize

@Parcelize
data class Content(
    var header: String,
    var title: String,
    var description: String,
    var image: String,
    var operators: List<Operator>
): Parcelable
