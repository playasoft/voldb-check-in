package net.wetfish.playasoftvolunteers.ui.shiftDetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Job
import net.wetfish.playasoftvolunteers.data.UserInfoRepository
import net.wetfish.playasoftvolunteers.data.db.UserDao
import net.wetfish.playasoftvolunteers.data.model.Shift

/**
 * Created by ${Michael} on 9/18/2019.
 */
class ShiftDetailsViewModel(
    database: UserDao,
    val shiftDetailKey: Long,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    //TODO: Get the Shift ID to open up the specific shift
    var shiftDetails = database.findShift(shiftDetailKey)

    private val shift = MutableLiveData<LiveData<Shift>>()

    fun getShift() = shift

    //TODO: Milestone #1 Base Implementation
    val shiftList = MediatorLiveData<List<Shift>>()

    private val userInfoRepository = UserInfoRepository(application)

    init {
        getAllShifts()
    }

    // 1
    fun getShiftList(): LiveData<List<Shift>> {
        return shiftList
    }

    // 2
    fun getAllShifts() {
        shiftList.addSource(userInfoRepository.findShifts(shiftDetailKey)) {
                shift -> shiftList.postValue(shift)
        }
    }
    // Shift Role id

    // Data that will be passed from the fragment
    private val _navigateToShiftsList = MutableLiveData<Long>()

    // Getter for what the fragment will observe
    val navigateToShiftsList get() = _navigateToShiftsList

    fun onShiftDetailClicked(id: Long) {
        _navigateToShiftsList.value = id
    }

    fun doneNavigating() {
        _navigateToShiftsList.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}