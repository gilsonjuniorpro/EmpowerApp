package empower.ca.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import empower.ca.repository.EmpowerRepository
import java.lang.IllegalArgumentException

class EmpowerViewModelFactory(
    private val repository: EmpowerRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(EmpowerViewModel::class.java)){
            return EmpowerViewModel(repository) as T
        }
        throw IllegalArgumentException("Unkown ViewModel Class")
    }
}
