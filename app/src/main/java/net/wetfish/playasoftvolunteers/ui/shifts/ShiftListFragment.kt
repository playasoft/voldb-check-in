package net.wetfish.playasoftvolunteers.ui.shifts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.db.VolunteerDatabase
import net.wetfish.playasoftvolunteers.databinding.FragmentShiftListBinding

/**
 * The Fragment to show the shift list
 */
class ShiftListFragment : Fragment() {

    // Logging Tag
    private val TAG = ShiftListFragment::class.qualifiedName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShiftListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_shift_list,
            container,
            false
        )

        val args = ShiftListFragmentArgs.fromBundle(arguments!!)

        val application = requireNotNull(this.activity).application

        val dataSource = VolunteerDatabase.getInstance(application).userDao

        val viewModelFactory = ShiftListViewModelFactory(dataSource, args.eventId, args.roleId, application)

        val viewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(ShiftListViewModel::class.java)

        binding.shiftListViewModel = viewModel

        binding.setLifecycleOwner(this)

        viewModel.navigateToShiftDetails.observe(this, Observer { list ->
            list?.let {
                this.findNavController().navigate(
                    ShiftListFragmentDirections.actionShiftListFragmentToShiftDetailsFragment(
                        list.get(0), list.get(1)
                    )
                )

                viewModel.doneNavigating()
            }
        })

        val adapter = ShiftListAdapter(ShiftListListener { shiftId, roleId ->
            viewModel.onShiftItemClicked(shiftId, roleId)
        })

        binding.rvShifts.adapter = adapter

        viewModel.shiftsList.observe(viewLifecycleOwner, Observer { it?.let {
            adapter.submitList(it)
        } })

        return binding.root
    }


}
