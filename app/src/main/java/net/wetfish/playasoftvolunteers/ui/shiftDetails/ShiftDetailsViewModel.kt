package net.wetfish.playasoftvolunteers.ui.shiftDetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import net.wetfish.playasoftvolunteers.App
import net.wetfish.playasoftvolunteers.data.model.Shift

/**
 * Created by ${Michael} on 9/18/2019.
 */
class ShiftDetailsViewModel(application: Application) : AndroidViewModel(application) {

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