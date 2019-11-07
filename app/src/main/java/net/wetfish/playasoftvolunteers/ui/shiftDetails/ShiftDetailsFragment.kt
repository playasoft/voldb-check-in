package net.wetfish.playasoftvolunteers.ui.shiftDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_shift_profile.*
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.model.Shift

/**
 * The Fragment to show the shift list
 */
class ShiftDetailsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shift_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Gather the shiftId to get the appropriate Departments
        val shiftDetails = arguments?.getParcelable<Shift>(getString(R.string.shift_details))

        // Start observing the selected shift
        if (shiftDetails != null) {
            populateShift(shiftDetails)
        }
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
