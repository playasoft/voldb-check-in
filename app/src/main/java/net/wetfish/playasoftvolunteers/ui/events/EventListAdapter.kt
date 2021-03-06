package net.wetfish.playasoftvolunteers.ui.events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import net.wetfish.playasoftvolunteers.data.model.Event
import net.wetfish.playasoftvolunteers.databinding.ListItemEventBinding

/**
 * Created by ${Michael} on 8/16/2019.
 */
class EventListAdapter(val clickListener: EventListListener) :
    ListAdapter<Event, EventListAdapter.ViewHolder>(EventListDiffCallback()) {

    /**
     * Creates view for each item in the list
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    /**
     * Binds view with item info
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }

    /**
     * View for item, sets item info and click events
     */
    class ViewHolder private constructor(val binding: ListItemEventBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event, clickListener: EventListListener) {
            binding.event = event
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemEventBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}

class EventListDiffCallback : DiffUtil.ItemCallback<Event>() {
    override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem == newItem
    }

}

class EventListListener(val clickListener: (eventId: Long) -> Unit) {
    fun onClick(event: Event) = clickListener(event.eventId.toLong())
}