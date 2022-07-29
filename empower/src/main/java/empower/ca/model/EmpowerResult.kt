package empower.ca.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class EmpowerResult(
    val items : List<Container>
): Parcelable
