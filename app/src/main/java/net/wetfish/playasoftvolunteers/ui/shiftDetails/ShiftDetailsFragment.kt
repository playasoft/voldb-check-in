package net.wetfish.playasoftvolunteers.ui.shiftDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_shift_list.*
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.model.Shift
import net.wetfish.playasoftvolunteers.ui.shifts.ShiftListAdapter

/**
 * The Fragment to show the shift list
 */
class ShiftDetailsFragment : Fragment(),
    ShiftListAdapter.OnItemClickListener {

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
        return inflater.inflate(R.layout.fragment_shift_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: Pass INT for the given shift
        // Start observing shift list
//        viewModel.getShiftDetails().observe(this, Observer<List<Shift>> { shifts ->
//            shifts?.let {
//                populateShiftList(shifts)
//            }
//        })
    }

    /**
     * Populates peopleRecyclerView with all people info
     */
    private fun populateShiftList(shiftList: List<Shift>) {
        rv_shifts.adapter = ShiftListAdapter(shiftList, this)
    }

    /**
     * Navigates to people details on item click
     */
    override fun onItemClick(shift: Shift, itemView: View) {
        //TODO: Fragment Transactions
    }

}
