package net.wetfish.playasoftvolunteers.ui.roles;

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.wetfish.playasoftvolunteers.data.db.UserDao

/**
 * Created by  on 11/29/2019.
 */
class RoleListViewModelFactory (
    private val dataSource: UserDao,
    private val role: Int,
    private val application: Application): ViewModelProvider.Factory {
    @Suppress("unchchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        if(modelClass.isAssignableFrom(RoleListViewModel::class.java)) {
            return RoleListViewModel(dataSource, role, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}

