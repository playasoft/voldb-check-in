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
    private val shiftId: Long,
    private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        if(modelClass.isAssignableFrom(ShiftListViewModel::class.java)) {
            return ShiftListViewModel(dataSource, shiftId, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}

