package net.wetfish.playasoftvolunteers.ui.shiftDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_shift_profile.*
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.model.Shift

/**
 * The Fragment to show the shift list
 */
class ShiftDetailsFragment : Fragment() {

    // ViewModel access
    private lateinit var viewModel: ShiftDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        // ViewModel initialization
        viewModel = ViewModelProviders.of(this).get(ShiftDetailsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shift_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Gather the shiftID to get the appropriate Departments
        val shiftID = arguments?.getInt(getString(R.string.shift_id))

        // Start observing the selected shift
        viewModel.getShift(shiftID!!).observe(this, Observer<Shift> { shift ->
            shift?.let {
                populateShift(shift)
            }
        })
    }

    /**
     * Populates peopleRecyclerView with all people info
     */
    private fun populateShift(shift: Shift) {
        tv_shiftUserDisplayName.text = shift.displayName
        tv_shiftUserFullName.text = shift.fullName
        tv_shiftUserEmail.text = shift.email
        tv_shiftStartDate.text = shift.startDate
        tv_shiftEndDate.text = shift.endDate
        tv_shiftStartTime.text = shift.startTime
        tv_shiftEndTime.text = shift.endTime
    }

}
