package net.wetfish.playasoftvolunteers.ui.shiftDetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import net.wetfish.playasoftvolunteers.App
import net.wetfish.playasoftvolunteers.data.db.UserDao
import net.wetfish.playasoftvolunteers.data.model.Shift

/**
 * Created by ${Michael} on 9/18/2019.
 */
class ShiftDetailsViewModel(dataSource: UserDao, shiftDetails: Int, application: Application) : AndroidViewModel(application) {

    private val viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    /**
     * This method will be called when this ViewModel is no longer used and will be destroyed.
     *
     *
     * It is useful when ViewModel observes some data and you need to clear this subscription to
     * prevent a leak of this ViewModel.
     */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val userInfoRepository = getApplication<App>().getUserInfoRepository()
    private var shift = MediatorLiveData<Shift>()

    fun getShift(shiftID: Int): LiveData<Shift> {
        findShift(shiftID)
        return shift
    }

    // Maps the shift ID to shift details
    fun findShift(eventID: Int) {
        shift = userInfoRepository.findShift(eventID) as MediatorLiveData<Shift>
    }
}