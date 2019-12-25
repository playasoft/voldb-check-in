package net.wetfish.playasoftvolunteers.ui.shifts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import net.wetfish.playasoftvolunteers.data.model.Shift
import net.wetfish.playasoftvolunteers.databinding.ListItemShiftBinding

/**
 * Created by ${Michael} on 8/16/2019.
 */
class ShiftListAdapter(val clickListener: ShiftListListener) :
    ListAdapter<Shift, ShiftListAdapter.ViewHolder>(ShiftListDiffCallback()) {

    /**
     * Notifies click on an item with attached view
     */
    interface OnItemClickListener {
        fun onItemClick(shift: Shift, itemView: View)
    }

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
     * View for item, sets item info and click shifts
     */
    class ViewHolder private constructor(val binding: ListItemShiftBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(shift: Shift, clickListener: ShiftListListener) {
            binding.shift = shift
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemShiftBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }

}

class ShiftListDiffCallback : DiffUtil.ItemCallback<Shift>() {
    override fun areItemsTheSame(oldItem: Shift, newItem: Shift): Boolean {
        return oldItem.shiftId == newItem.shiftId
    }

    override fun areContentsTheSame(oldItem: Shift, newItem: Shift): Boolean {
        return oldItem == newItem
    }
}

class ShiftListListener(val clickListener: (shiftId: Long) -> Unit) {
    fun onClick(shift: Shift) = clickListener(shift.shiftId.toLong())
}