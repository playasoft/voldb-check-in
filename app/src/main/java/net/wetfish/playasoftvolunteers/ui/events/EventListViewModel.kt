package net.wetfish.playasoftvolunteers.ui.events

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import net.wetfish.playasoftvolunteers.data.db.UserDao
import net.wetfish.playasoftvolunteers.data.model.Department
import net.wetfish.playasoftvolunteers.data.model.Event
import net.wetfish.playasoftvolunteers.data.net.UserInfoProvider.Companion.eventList

/**
 * Created by ${Michael} on 8/17/2019.
 */
class EventListViewModel(
    database: UserDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var events = database.getEvents()

    // Live data that will change when we want to navigate that will be observed and changed when we
    // wanat to navigate
    private val _navigateToDepartmentList = MutableLiveData<List<Department>>()

    // Getter for what the fragment  will observe
    val navigateToDepartmentList: LiveData<List<Department>> get() = _navigateToDepartmentList

    // Reset after navigating
    fun doneNavigating() {
        _navigateToDepartmentList.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    init {
        getAllEvents()
    }

    // 1
    fun getEventList(): LiveData<List<Event>> {
        return eventList
    }

    // 2
    fun getAllEvents() {
        eventList.addSource(userInfoRepository.getEvents()) { events ->
            eventList.postValue(events)
        }
    }

}
