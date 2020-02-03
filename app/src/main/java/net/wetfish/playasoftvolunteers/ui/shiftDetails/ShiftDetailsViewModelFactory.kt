package net.wetfish.playasoftvolunteers.ui.shiftDetails

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.wetfish.playasoftvolunteers.data.db.UserDao

/**
 * Created by  on 11/29/2019.
 */
class ShiftDetailsViewModelFactory(
    private val dataSource: UserDao,
    private val shiftDetailsId: Long,
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShiftDetailsViewModel::class.java)) {
            return ShiftDetailsViewModel(dataSource, shiftDetailsId, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
