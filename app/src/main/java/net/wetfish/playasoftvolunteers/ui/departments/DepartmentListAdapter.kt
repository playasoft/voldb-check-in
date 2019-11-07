package net.wetfish.playasoftvolunteers.ui.departments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_list_department_item.view.*
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.model.Department

/**
 * Created by ${Michael} on 8/16/2019.
 */
class DepartmentListAdapter : PagedListAdapter<Department, DepartmentListAdapter.ViewHolder>(DepartmentListDiffCallback()) {

    private lateinit var recyclerView: RecyclerView

    /**
     * Binds view with item info
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val department = getItem(position)
        department?.let {
            holder.apply {
                bind(createOnClickListener(department.departmentId), department)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemDepartmentBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    /**
     * Notifies click on an item with attached view
     */
    interface OnItemClickListener {
        fun onItemClick(department: Department, itemView: View)
    }

    /**
     * Creates onClickListener for each item in the list
     */
    private fun createOnClickListener(id: String): View.OnClickListener {
        return View.OnClickListener {
            val direction = DepartmentListFragmentDirections.actionToRolesListFragment(id)
            it.findNavController().navigate(direction)
        }
    }

    /**
     * View for item, sets item info and click departments
     */
    class ViewHolder(private val binding: list_item_department)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Department) {
            binding.apply {
                clickListener = listener
                department = item
                executePendingBindings()
            }
        }

    }

//    class ViewHolder(private val binding: ListItemDepartmentBinding)
//        : RecyclerView.ViewHolder(bi) {
//
//        fun bind(department: Department, listener: OnItemClickListener) = with(itemView) {
//            tv_departmentName.text = department.departmentName
//            setOnClickListener {
//
//                //TODO:: Figure this out later
//            }
//
//            // RecyclerView on item click
//            setOnClickListener {
//                listener.onItemClick(department, it)
//            }
//        }
//
//    }

}

private class DepartmentListDiffCallback : DiffUtil.ItemCallback<Department>() {

    override fun areItemsTheSame(oldItem: Department, newItem: Department): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Department, newItem: Department): Boolean {
        return oldItem == newItem
    }
}