package net.wetfish.playasoftvolunteers.ui.events

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import net.wetfish.playasoftvolunteers.PlayasoftVolunteers
import net.wetfish.playasoftvolunteers.data.model.Role

/**
 * Created by ${Michael} on 8/17/2019.
 */
class RoleListViewModel(application: Application) : AndroidViewModel(application) {

    private val userInfoRepository = getApplication<PlayasoftVolunteers>().getUserInfoRepository()
    private val eventList = MediatorLiveData<List<Role>>()

    init {
        getAllRoles()
    }

    // 1
    fun getRoleList(): LiveData<List<Role>> {
        return eventList
    }

    // 2
    fun getAllRoles() {
        eventList.addSource(userInfoRepository.getRoles()) { roles ->
            eventList.postValue(roles)
        }
    }

}
