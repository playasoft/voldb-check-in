package net.wetfish.playasoftvolunteers.ui.events

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_list_event_item.view.*
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.model.Event

/**
 * Created by ${Michael} on 8/16/2019.
 */
class EventListAdapter(
    private val eventData: List<Event>,
    private val clickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * Notifies click on an item with attached view
     */
    interface OnItemClickListener {
        fun onItemClick(event: Event, itemView: View)
    }

    /**
     * Creates view for each item in the list
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder.from(parent)
    }

    /**
     * Binds view with item info
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(eventData[position], clickListener)
    }

    /**
     * Returns the size to item list
     */
    override fun getItemCount(): Int {
        return eventData.size
    }

    /**
     * View for item, sets item info and click events
     */
    class ViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(event: Event, listener: OnItemClickListener) = with(itemView) {
            tv_eventName.text = event.eventName
            tv_eventStart.text = event.startDate
            tv_eventEnd.text = event.endDate

            // RecyclerView on item click
            setOnClickListener {
                listener.onItemClick(event, it)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_list_event_item, parent, false)
                return ViewHolder(view)
            }
        }

    }

}