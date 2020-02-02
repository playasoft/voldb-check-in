package net.wetfish.playasoftvolunteers.ui.events;

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.wetfish.playasoftvolunteers.data.db.UserDao

/**
 * Created by  on 11/29/2019.
 */
class EventListViewModelFactory (
    private val dataSource: UserDao,
    private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(EventListViewModel::class.java)) {
            return EventListViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

