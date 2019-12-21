package net.wetfish.playasoftvolunteers.ui.events

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.db.VolunteerDatabase
import net.wetfish.playasoftvolunteers.data.model.Event
import net.wetfish.playasoftvolunteers.databinding.FragmentEventListBinding

/**
 * The Fragment to show the event list
 */
class EventListFragment : Fragment(),
    EventListAdapter.OnItemClickListener {

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
            false)

        val application = requireNotNull(this.activity).application

        val dataSource = VolunteerDatabase.getInstance(application).userDao

        val viewModelFactory = EventListViewModelFactory(dataSource, application)

        val viewModel = ViewModelProviders.of(
            this, viewModelFactory).get(EventListViewModel::class.java)

        binding.eventListViewModel = viewModel

        binding.setLifecycleOwner(this)

        viewModel.navigateToDepartmentList.observe(this, Observer {
            event -> event?.let {
            this.findNavController().navigate(
                EventListFragmentDirections.actionEventListFragmentToDepartmentListFragment(Integer.valueOf(event.eventId)))

            viewModel.doneNavigating()
        }
        })

        val adapter = EventListAdapter()
        binding.rvEvents.adapter = adapter

        viewModel.eventsList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }

    /**
     * Navigates to people details on item click
     */
//    override fun onItemClick(event: Event, itemView: View) {
//        Log.d(TAG, "Yoyoyoyoyo: " + event.eventId)
//        Log.d(TAG, "Yoyoyoyoyo: " + event.id)
//        // Get the event ID and bundle it for transferring to departments
//        val eventBundle = Bundle().apply {
//            putInt(getString(R.string.event_id), (event.eventId).toInt())
//        }
//
//        view?.findNavController()
//            ?.navigate(EventListFragmentDirections.actionEventListFragmentToDepartmentListFragment((event.eventId).toInt()))
//    }
}
