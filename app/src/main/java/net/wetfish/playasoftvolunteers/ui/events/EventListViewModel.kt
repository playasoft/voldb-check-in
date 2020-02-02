package net.wetfish.playasoftvolunteers.ui.events

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import net.wetfish.playasoftvolunteers.data.UserInfoRepository
import net.wetfish.playasoftvolunteers.data.db.UserDao
import net.wetfish.playasoftvolunteers.data.model.Event

/**
 * Created by ${Michael} on 8/17/2019.
 */
class EventListViewModel(
    val database: UserDao,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val events = MediatorLiveData<List<Event?>>()

    //TODO: Milestone #1 Base Implementation
    val eventsList = MediatorLiveData<List<Event>>()

    private val userInfoRepository = UserInfoRepository(application)

    init {
        getAllEvents()
    }

    // 1
    fun getEventList(): LiveData<List<Event>> {
        return eventsList
    }

    // 2
    fun getAllEvents() {
        eventsList.addSource(userInfoRepository.getEvents()) {
            events -> eventsList.postValue(events)
        }
    }

    // Data that will be passed from the fragment
    private val _navigateToDepartmentList = MutableLiveData<Long>()

    // Getter for what the fragment  will observe
    val navigateToDepartmentList get() = _navigateToDepartmentList

    // When the event item is clicked
    fun onEventItemClicked(id: Long) {
        _navigateToDepartmentList.value = id
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
