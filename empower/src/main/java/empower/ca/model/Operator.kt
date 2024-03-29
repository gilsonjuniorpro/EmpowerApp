package empower.ca.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Operator(
    @PrimaryKey
    var id: String,
    var type: String?, // button or link
    var actionType: String?, // open detail or open link
    var actionValue: String?, // url link or detail screen
    var text: String?
): Parcelable {

}
