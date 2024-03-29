package empower.ca.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
class Content (
    @PrimaryKey
    var id: String,
    var header: String?,
    var title: String?,
    var description: String?,
    var image: String?,
    var operators: List<Operator>
): Parcelable {

}
