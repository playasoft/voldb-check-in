package net.wetfish.playasoftvolunteers.ui.shifts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_list_shift_item.view.*
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.model.Shift

/**
 * Created by ${Michael} on 8/16/2019.
 */
class ShiftListAdapter(
    private val items: List<Shift>,
    private val clickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * Notifies click on an item with attached view
     */
    interface OnItemClickListener {
        fun onItemClick(shift: Shift, itemView: View)
    }

    /**
     * Creates view for each item in the list
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_list_shift_item, parent, false)
        return ViewHolder(view)
    }

    /**
     * Binds view with item info
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(items[position], clickListener)
    }

    /**
     * Returns the size to item list
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * View for item, sets item info and click shifts
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(shift: Shift, listener: OnItemClickListener) = with(itemView) {
            tv_shiftUserDisplayName.text = shift.displayName
            tv_shiftUserFullName.text = shift.fullName
            tv_shiftStartDate.text = shift.startDate
            tv_shiftEndDate.text = shift.endDate
            tv_shiftStartTime.text = shift.startTime
            tv_shiftEndTime.text = shift.endTime

            setOnClickListener {
                //TODO:: Figure this out later
            }

            // RecyclerView on item click
            setOnClickListener {
                listener.onItemClick(shift, it)
            }
        }

    }

}