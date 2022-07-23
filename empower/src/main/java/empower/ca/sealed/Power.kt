package empower.ca.sealed

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


sealed class Power : Parcelable {

    @Parcelize
    object Basic : Power()

    @Parcelize
    object Banner : Power()

    @Parcelize
    object Expose : Power()

    @Parcelize
    object Ads : Power()

    fun getTitle(what: Power): String {
        return when (what) {
            is Power.Ads -> {
                "This is the Ads"
            }
            is Power.Basic -> {
                "This is the Basic"
            }
            is Power.Banner -> {
                "This is the Banner"
            }
            is Power.Expose -> {
                "This is the Expose"
            }
        }
    }
}
