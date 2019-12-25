package net.wetfish.playasoftvolunteers.ui.shifts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import net.wetfish.playasoftvolunteers.data.db.UserDao
import net.wetfish.playasoftvolunteers.data.model.Shift

/**
 * Created by ${Michael} on 8/17/2019.
 */
class ShiftListViewModel(
    database: UserDao,
    shiftKey: Long,
    application: Application
) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var shiftsList = database.findShifts(shiftKey)

    private val shifts = MutableLiveData<LiveData<List<Shift>>>()

    fun getShifts() = shifts

    init {
        shifts.postValue(database.findShifts(shiftKey))
    }

    // Data that will be passed from the fragment
    private val _navigateToShiftDetails = MutableLiveData<Long>()

    // Getter for what the fragment will observe
    val navigateToShiftDetails get() = _navigateToShiftDetails

    fun onShiftItemClicked(id: Long) {
        _navigateToShiftDetails.value = id
    }

    fun doneNavigating() {
        _navigateToShiftDetails.value = null
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}