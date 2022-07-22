package empower.ca.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Operator(
    var type: String, // button or link
    var actionType: String, // open detail or open link
    var actionValue: String, // url link or detail screen
    var text: String
): Parcelable
