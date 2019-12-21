package net.wetfish.playasoftvolunteers.ui.events

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import net.wetfish.playasoftvolunteers.data.db.UserDao
import net.wetfish.playasoftvolunteers.data.model.Event

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

    // Live data that will change when we want to navigate that will be observed and changed when we
    // want to navigate
    private val _navigateToDepartmentList = MutableLiveData<Event>()

    // Getter for what the fragment  will observe
    val navigateToDepartmentList: LiveData<Event> get() = _navigateToDepartmentList

    // Reset after navigating
    fun doneNavigating() {
        _navigateToDepartmentList.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
