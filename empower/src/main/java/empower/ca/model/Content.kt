package empower.ca.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Content(
    var contentType: String,
    var header: String,
    var title: String,
    var description: String,
    var image: String,
    var operators: List<Operator>
): Parcelable
