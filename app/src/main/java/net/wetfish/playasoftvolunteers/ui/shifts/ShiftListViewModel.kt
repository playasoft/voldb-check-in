package net.wetfish.playasoftvolunteers.ui.shifts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import net.wetfish.playasoftvolunteers.data.UserInfoRepository
import net.wetfish.playasoftvolunteers.data.db.UserDao
import net.wetfish.playasoftvolunteers.data.model.Shift

/**
 * Created by ${Michael} on 8/17/2019.
 */
class ShiftListViewModel(
    database: UserDao,
    val eventId: Long,
    val roleId: Long,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

//    var shiftsList = database.findShifts(shiftKey)

    private val shifts = MutableLiveData<LiveData<List<Shift>>>()

    fun getShifts() = shifts

    //TODO: Milestone #1 Base Implementation
    val shiftsList = MediatorLiveData<List<Shift>>()

    private val userInfoRepository = UserInfoRepository(application)

    init {
        getAllShifts()
    }

    // 1
    fun getShiftList(): LiveData<List<Shift>> {
        return shiftsList
    }

    // 2
    fun getAllShifts() {
        shiftsList.addSource(userInfoRepository.findShifts(eventId, roleId)) {
                shifts -> shiftsList.postValue(shifts)
        }
    }
    // Data that will be passed from the fragment
    private val _navigateToShiftDetails = MutableLiveData<List<Long>>()

    // Getter for what the fragment will observe
    val navigateToShiftDetails get() = _navigateToShiftDetails

    fun onShiftItemClicked(shiftId: Long, roleId: Long) {
        _navigateToShiftDetails.value = listOf(shiftId, roleId)
    }

    fun doneNavigating() {
        _navigateToShiftDetails.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}