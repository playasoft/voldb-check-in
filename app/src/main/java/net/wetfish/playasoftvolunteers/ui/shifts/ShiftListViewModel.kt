package net.wetfish.playasoftvolunteers.ui.shifts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import net.wetfish.playasoftvolunteers.PlayasoftVolunteers
import net.wetfish.playasoftvolunteers.data.model.Shift

/**
 * Created by ${Michael} on 8/17/2019.
 */
class ShiftListViewModel(application: Application) : AndroidViewModel(application) {

    private val userInfoRepository = getApplication<PlayasoftVolunteers>().getUserInfoRepository()
    private val shiftList = MediatorLiveData<List<Shift>>()

    init {
        getAllShifts()
    }

    // 1
    fun getShiftList(): LiveData<List<Shift>> {
        return shiftList
    }

    // 2
    fun getAllShifts() {
        shiftList.addSource(userInfoRepository.getShifts()) { shifts ->
            shiftList.postValue(shifts)
        }
    }

}
