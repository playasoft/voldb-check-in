package net.wetfish.playasoftvolunteers.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_event_list.*
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.model.Event

/**
 * The Fragment to show the event list
 */
class EventListFragment : Fragment(),
    EventListAdapter.OnItemClickListener{

    // ViewModel access
    private lateinit var viewModel: EventListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        // ViewModel initialization
        viewModel = ViewModelProviders.of(this).get(EventListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_event_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Start observing event list
        viewModel.getEventList().observe(this, Observer<List<Event>> { events ->
            events?.let {
                populateEventList(events)
            }
        })
    }

    /**
     * Populates peopleRecyclerView with all people info
     */
    private fun populateEventList(eventList: List<Event>) {
        rv_events.adapter = EventListAdapter(eventList, this)
    }

    /**
     * Navigates to people details on item click
     */
    override fun onItemClick(event: Event, itemView: View) {
        // Get the event ID and bundle it for transferring to departments
        val eventBundle = Bundle().apply {
            putInt(getString(R.string.event_id), (event.eventID).toInt())
        }

        view?.findNavController()
            ?.navigate(R.id.action_eventListFragment_to_departmentListFragment, eventBundle)
    }

}
