package net.wetfish.playasoftvolunteers.ui.shiftDetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import net.wetfish.playasoftvolunteers.PlayasoftVolunteers
import net.wetfish.playasoftvolunteers.data.model.Shift

/**
 * Created by ${Michael} on 9/18/2019.
 */
class ShiftDetailsViewModel(application: Application) : AndroidViewModel(application) {

    private val userInfoRepository = getApplication<PlayasoftVolunteers>().getUserInfoRepository()
    private val shiftID = MutableLiveData<Int>()

    // Maps the shift ID to shift details
    fun getShiftDetails(id: Int): LiveData<Shift> {
        shiftID.value = id
        val shiftDetails =
            Transformations.switchMap<Int, Shift>(shiftID) { id ->
            userInfoRepository.findShift(id)
        }
        return shiftDetails
    }
}