package empower.ca.sealed

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


sealed class Power : Parcelable {

    @Parcelize
    object Basic : Power()

    @Parcelize
    object Banner : Power()

    @Parcelize
    object Expose : Power()

    @Parcelize
    object Ads : Power()
}
