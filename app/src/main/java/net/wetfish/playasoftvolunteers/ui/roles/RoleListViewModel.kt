package net.wetfish.playasoftvolunteers.ui.roles

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import net.wetfish.playasoftvolunteers.App
import net.wetfish.playasoftvolunteers.data.db.UserDao
import net.wetfish.playasoftvolunteers.data.model.Role

/**
 * Created by ${Michael} on 8/17/2019.
 */
class RoleListViewModel(dataSource: UserDao, role: Int, application: Application) : AndroidViewModel(application) {

    private val userInfoRepository = getApplication<App>().getUserInfoRepository()
    private val roleList = MediatorLiveData<List<Role>>()

    //TODO: This initialization may be pointless
//    init {
//        getAllRoles()
//    }

    fun getRoleList(departmentID: Int): LiveData<List<Role>> {
        findRoles(departmentID)
        return roleList
    }

//    fun getAllRoles() {
//        roleList.addSource(userInfoRepository.getRoles()) { roles ->
//            roleList.postValue(roles)
//        }
//    }

    fun findRoles(eventID: Int) {
        roleList.addSource(userInfoRepository.findRoles(eventID)) { roles ->
            roleList.postValue(roles)
        }
    }
}
