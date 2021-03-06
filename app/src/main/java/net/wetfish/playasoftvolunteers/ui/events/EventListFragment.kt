package net.wetfish.playasoftvolunteers.ui.events

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
import net.wetfish.playasoftvolunteers.databinding.FragmentEventListBinding

/**
 * The Fragment to show the event list
 */
class EventListFragment : Fragment() {

    // Logging Tag
    private val TAG = EventListFragment::class.qualifiedName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentEventListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_event_list,
            container,
            false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = VolunteerDatabase.getInstance(application).userDao

        val viewModelFactory = EventListViewModelFactory(dataSource, application)

        val viewModel = ViewModelProvider(
            this, viewModelFactory).get(EventListViewModel::class.java)

        binding.eventListViewModel = viewModel

        binding.setLifecycleOwner(this)

        viewModel.navigateToDepartmentList.observe(this, Observer { eventId ->
            eventId?.let {
                this.findNavController().navigate(
                    EventListFragmentDirections.actionEventListFragmentToDepartmentListFragment(
                        eventId))
                viewModel.doneNavigating()
            }
        })

        val adapter = EventListAdapter(EventListListener { eventId ->
            viewModel.onEventItemClicked(eventId)
        })

        binding.rvEvents.adapter = adapter

        viewModel.eventsList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }
}
