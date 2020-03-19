package net.wetfish.playasoftvolunteers.ui.shifts;

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.wetfish.playasoftvolunteers.data.db.UserDao

/**
 * Created by  on 11/29/2019.
 */
class ShiftListViewModelFactory (
    private val dataSource: UserDao,
    private val eventId: Long,
    private val roleId: Long,
    private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ShiftListViewModel::class.java)) {
            return ShiftListViewModel(dataSource, eventId, roleId, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}

