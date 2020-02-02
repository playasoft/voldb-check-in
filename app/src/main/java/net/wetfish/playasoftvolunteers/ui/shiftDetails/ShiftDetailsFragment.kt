package net.wetfish.playasoftvolunteers.ui.shiftDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.db.VolunteerDatabase
import net.wetfish.playasoftvolunteers.databinding.FragmentShiftDetailsBinding

/**
 * The Fragment to show the shift list
 */
class ShiftDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShiftDetailsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shift_details, container, false
        )

        val args = ShiftDetailsFragmentArgs.fromBundle(arguments!!)

        val application = requireNotNull(this.activity).application

        val dataSource = VolunteerDatabase.getInstance(application).userDao

        val viewModelFactory = ShiftDetailsViewModelFactory(dataSource, args.shiftId, application)

        val viewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(ShiftDetailsViewModel::class.java)

        binding.shiftDetailsViewModel = viewModel

        binding.setLifecycleOwner(this)

//        viewModel.navigateToShiftsList.observe(this, Observer {
//            if (it == true) {
//                shift view
//                this.findNavController().navigate(
//                    ShiftDetailsFragmentDirections.actionShiftDetailsFragmentToShiftListFragment(viewModel.getShift().)
//                )
//            }
//
//        })

        return binding.root
    }
}
