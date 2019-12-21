package net.wetfish.playasoftvolunteers.ui.events

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import net.wetfish.playasoftvolunteers.data.db.UserDao

/**
 * Created by ${Michael} on 8/17/2019.
 */
class EventListViewModel(
    database: UserDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var eventsList = database.getEvents()

    // Data that will be passed from the fragment
    private val _navigateToDepartmentList = MutableLiveData<Long>()

    // Getter for what the fragment  will observe
    val navigateToDepartmentList get() = _navigateToDepartmentList

    fun onEventItemClicked(id: Long) {
        _navigateToDepartmentList.value = id
    }

    fun onDepartmentListNavigated() {
        _navigateToDepartmentList.value = null
    }

    // Reset after navigating
    fun doneNavigating() {
        _navigateToDepartmentList.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
