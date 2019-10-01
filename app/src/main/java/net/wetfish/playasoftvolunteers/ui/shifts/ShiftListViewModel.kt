package net.wetfish.playasoftvolunteers.ui.shifts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import net.wetfish.playasoftvolunteers.data.app.PlayasoftVolunteers
import net.wetfish.playasoftvolunteers.data.model.Shift

/**
 * Created by ${Michael} on 8/17/2019.
 */
class ShiftListViewModel(application: Application) : AndroidViewModel(application) {

    private val userInfoRepository = getApplication<PlayasoftVolunteers>().getUserInfoRepository()
    private val shiftList = MediatorLiveData<List<Shift>>()

    //TODO: This initialization may be pointless
//    init {
//        getAllShifts()
//    }

    fun getShiftList(roleID: Int): LiveData<List<Shift>> {
        findShifts(roleID)
        return shiftList
    }

//    fun getAllShifts() {
//        shiftList.addSource(userInfoRepository.getShifts()) { shifts ->
//            shiftList.postValue(shifts)
//        }
//    }

    fun findShifts(eventID: Int) {
        shiftList.addSource(userInfoRepository.findShifts(eventID)) { shifts ->
            shiftList.postValue(shifts)
        }
    }
}
