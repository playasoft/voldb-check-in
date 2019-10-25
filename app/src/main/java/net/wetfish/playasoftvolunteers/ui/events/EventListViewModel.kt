package net.wetfish.playasoftvolunteers.ui.events

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import net.wetfish.playasoftvolunteers.App
import net.wetfish.playasoftvolunteers.data.model.Event

/**
 * Created by ${Michael} on 8/17/2019.
 */
class EventListViewModel(application: Application) : AndroidViewModel(application) {

    private val userInfoRepository = getApplication<App>().getUserInfoRepository()
    private val eventList = MediatorLiveData<List<Event>>()

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
