package net.wetfish.playasoftvolunteers.ui.departments

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import net.wetfish.playasoftvolunteers.data.UserInfoRepository
import net.wetfish.playasoftvolunteers.data.db.UserDao
import net.wetfish.playasoftvolunteers.data.model.Department

/**
 * Created by ${Michael} on 8/17/2019.
 */
class DepartmentListViewModel(
    database: UserDao,
    val eventId: Long,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

//    var departmentsList = database.findDepartments(departmentKey)

    private val departments = MutableLiveData<LiveData<List<Department>>>()

    fun getDepartments() = departments

    // Initialize
    //TODO: Milestone #1 Base Implementation
    val departmentsList = MediatorLiveData<List<Department>>()

    private val userInfoRepository = UserInfoRepository(application)

    init {
        getAllDepartments()
    }

    // 1
    fun getDepartmentList(): LiveData<List<Department>> {
        return departmentsList
    }

    // 2
    fun getAllDepartments() {
        departmentsList.addSource(userInfoRepository.findDepartments(eventId)) {
                departments -> departmentsList.postValue(departments)
        }
    }

    // Data that will be passed from the fragment
    private val _navigateToRoleList = MutableLiveData<Long>()

    // Getter for what the fragment will observe
    val navigateToRoleList get() = _navigateToRoleList

    // When the department item is clicked
    fun onDepartmentItemClicked(id: Long) {
        Log.d(DepartmentListViewModel::class.qualifiedName, "What's happening" + id);
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
