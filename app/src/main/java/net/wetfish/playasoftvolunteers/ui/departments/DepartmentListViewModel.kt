package net.wetfish.playasoftvolunteers.ui.departments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import net.wetfish.playasoftvolunteers.data.db.UserDao
import net.wetfish.playasoftvolunteers.data.model.Department

/**
 * Created by ${Michael} on 8/17/2019.
 */
class DepartmentListViewModel(
    database: UserDao,
    departmentKey: Long,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var departmentsList = database.findDepartments(departmentKey)

    private val departments = MutableLiveData<LiveData<List<Department>>>()

    fun getDepartments() = departments

    // Initialize
    init {
        departments.postValue(database.findDepartments(departmentKey))
    }

    // Data that will be passed from the fragment
    private val _navigateToRoleList = MutableLiveData<Long>()

    // Getter for what the fragment will observe
    val navigateToRoleList get() = _navigateToRoleList

    // When the department item is clicked
    fun onDepartmentItemClicked(id: Long) {
        _navigateToRoleList.value = id
    }

    // Rest after navigating
    fun doneNavigating() {
        _navigateToRoleList.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
