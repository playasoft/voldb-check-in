package net.wetfish.playasoftvolunteers.ui.events

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
    private val eventList = MediatorLiveData<List<Department>>()

    init {
        getAllDepartments()
    }

    // 1
    fun getDepartmentList(): LiveData<List<Department>> {
        return eventList
    }

    // 2
    fun getAllDepartments() {
        eventList.addSource(userInfoRepository.getDepartments()) { departments ->
            eventList.postValue(departments)
        }
    }

}
