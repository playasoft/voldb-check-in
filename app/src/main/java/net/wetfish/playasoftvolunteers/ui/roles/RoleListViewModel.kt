package net.wetfish.playasoftvolunteers.ui.roles

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
    private val roleList = MediatorLiveData<List<Role>>()

    init {
        getAllRoles()
    }

    // 1
    fun getRoleList(): LiveData<List<Role>> {
        return roleList
    }

    // 2
    fun getAllRoles() {
        roleList.addSource(userInfoRepository.getRoles()) { roles ->
            roleList.postValue(roles)
        }
    }

}
