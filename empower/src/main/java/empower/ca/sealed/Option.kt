package empower.ca.sealed

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


sealed class Option : Parcelable {

    @Parcelize
    class Container(val title: String? = null, val linkText: String? = null) : Option()

}


