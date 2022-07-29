package empower.ca.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OperatorDto(
    var type: String?, // button or link
    var actionType: String?, // open detail or open link
    var actionValue: String?, // url link or detail screen
    var text: String?
): Parcelable
