package net.wetfish.playasoftvolunteers.ui.departments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import net.wetfish.playasoftvolunteers.data.model.Department
import net.wetfish.playasoftvolunteers.databinding.ListItemDepartmentBinding

/**
 * Created by ${Michael} on 8/16/2019.
 */
class DepartmentListAdapter(val clickListener: DepartmentListListener) :
    ListAdapter<Department, DepartmentListAdapter.ViewHolder>(DepartmentListDiffCallback()) {

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
     * View for item, sets item info and click departments
     */
    class ViewHolder private constructor(val binding: ListItemDepartmentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(department: Department, clickListener: DepartmentListListener) {
            binding.department = department
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemDepartmentBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

}

class DepartmentListDiffCallback : DiffUtil.ItemCallback<Department>() {
    override fun areItemsTheSame(oldItem: Department, newItem: Department): Boolean {
        return oldItem.departmentId == newItem.departmentId
    }

    override fun areContentsTheSame(oldItem: Department, newItem: Department): Boolean {
        return oldItem == newItem
    }
}

class DepartmentListListener(val clickListener: (eventId: Long) -> Unit) {
    fun onClick(department: Department) = clickListener(department.departmentId.toLong())
}