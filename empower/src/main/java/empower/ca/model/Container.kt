package empower.ca.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Container(
    @PrimaryKey
    var id: String,
    var containerTitle: String = "",
    var contentType: String = "EMPOWER_VIEWTYPE_BASIC",
    var contents: List<Content> = ArrayList()
): Parcelable {

}
