package empower.ca.core

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import empower.ca.fragment.EmpowerFragment
import empower.ca.fragment.EmpowerFragment.Companion.EMPOWER_CONTENT_OBJECT
import empower.ca.fragment.EmpowerFragment.Companion.EMPOWER_OPTION_OBJECT
import empower.ca.fragment.EmpowerFragment.Companion.EMPOWER_POWER_OBJECT
import empower.ca.fragment.EmpowerFragment.Companion.INSTANCE_HASH_CODE
import empower.ca.model.Content
import empower.ca.sealed.Option
import empower.ca.sealed.Power

object Empower {

    fun fragment(context: Context, option: Option, power: Power, content: ArrayList<Content>? = null): Fragment {
        val bundle = Bundle()
        bundle.putParcelable(EMPOWER_POWER_OBJECT, power)
        bundle.putParcelable(EMPOWER_OPTION_OBJECT, option)
        bundle.putParcelableArrayList(EMPOWER_CONTENT_OBJECT, content)

        val empowerInstance = EmpowerFragment.newInstance()
        val empowerHashCode = empowerInstance.hashCode()
        bundle.putInt(INSTANCE_HASH_CODE, empowerHashCode)
        empowerInstance.arguments = bundle

        return empowerInstance
    }

}
