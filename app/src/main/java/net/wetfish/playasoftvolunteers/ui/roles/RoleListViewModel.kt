package net.wetfish.playasoftvolunteers.ui.roles

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import net.wetfish.playasoftvolunteers.data.db.UserDao
import net.wetfish.playasoftvolunteers.data.model.Role

/**
 * Created by ${Michael} on 8/17/2019.
 */
class RoleListViewModel(
    database: UserDao,
    roleKey: Long,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var rolesList = database.findRoles(roleKey)

    private val roles = MutableLiveData<LiveData<List<Role>>>()

    fun getRoles() = roles

    init {
        roles.postValue(database.findRoles(roleKey))
    }

    // Data that will be passed from the fragment
    private val _navigateToRoleList = MutableLiveData<Long>()

    // Getter for what the fragment will observe
    val navigateToRoleList get() = _navigateToRoleList

    fun onDepartmentClicked(id: Long) {
        _navigateToRoleList.value = id
    }

    fun doneNavigating() {
        _navigateToRoleList.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}