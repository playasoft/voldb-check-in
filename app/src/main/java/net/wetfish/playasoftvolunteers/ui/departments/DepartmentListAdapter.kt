package net.wetfish.playasoftvolunteers.ui.departments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_list_department_item.view.*
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.model.Department

/**
 * Created by ${Michael} on 8/16/2019.
 */
class DepartmentListAdapter(
    private val items: List<Department>,
    private val clickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * Notifies click on an item with attached view
     */
    interface OnItemClickListener {
        fun onItemClick(department: Department, itemView: View)
    }

    /**
     * Creates view for each item in the list
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_list_department_item, parent, false)
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
     * View for item, sets item info and click departments
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(department: Department, listener: OnItemClickListener) = with(itemView) {
            tv_departmentName.text = department.name
            setOnClickListener {

                //TODO:: Figure this out later
            }

            // RecyclerView on item click
            setOnClickListener {
                listener.onItemClick(department, it)
            }
        }

    }

}