package net.wetfish.playasoftvolunteers.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_shift_list.*
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.model.Shift
import net.wetfish.playasoftvolunteers.ui.shifts.ShiftListAdapter
import net.wetfish.playasoftvolunteers.ui.shifts.ShiftListViewModel

/**
 * The Fragment to show the shift list
 */
class ShiftListFragment : Fragment(),
    ShiftListAdapter.OnItemClickListener {

    private lateinit var viewModel: ShiftListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        viewModel = ViewModelProviders.of(this).get(ShiftListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shift_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Start observing event list
        viewModel.getShiftList().observe(this, Observer<List<Shift>> { shifts ->
            shifts?.let {
                populateShiftList(shifts)
            }
        })
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
    override fun onItemClick(event: Shift, itemView: View) {
        //TODO: Fragment Transactions
    }

}
