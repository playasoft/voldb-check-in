package net.wetfish.playasoftvolunteers.ui.departments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import net.wetfish.playasoftvolunteers.PlayasoftVolunteers
import net.wetfish.playasoftvolunteers.data.model.Department

/**
 * Created by ${Michael} on 8/17/2019.
 */
class DepartmentListViewModel(application: Application) : AndroidViewModel(application) {

    private val userInfoRepository = getApplication<PlayasoftVolunteers>().getUserInfoRepository()
    private val departmentList = MediatorLiveData<List<Department>>()

    init {
        getAllDepartments()
    }

    // 1
    fun getDepartmentList(): LiveData<List<Department>> {
        return departmentList
    }

    // 2
    fun getAllDepartments() {
        departmentList.addSource(userInfoRepository.getDepartments()) { departments ->
            departmentList.postValue(departments)
        }
    }

}
