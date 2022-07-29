package empower.ca.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
class FullJson(
    @PrimaryKey
    val id: String,
    val json: String,
    val url: String
): Parcelable {

}
