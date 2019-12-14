package net.wetfish.playasoftvolunteers.ui.departments;

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.wetfish.playasoftvolunteers.data.db.UserDao

/**
 * Created by  on 11/29/2019.
 */

class DepartmentListViewModelFactory (
    private val dataSource: UserDao,
    private val event: Int,
    private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        if(modelClass.isAssignableFrom(DepartmentListViewModel::class.java)) {
            return DepartmentListViewModel(dataSource, event, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}