package net.wetfish.playasoftvolunteers.ui.roles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item_role.view.*
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.model.Department
import net.wetfish.playasoftvolunteers.data.model.Role

/**
 * Created by ${Michael} on 8/16/2019.
 */
class RoleListAdapter(val clickListener: RoleListListener):
        ListAdapter<Role, RoleListAdapter.ViewHolder>(RoleListDiffCallback()) {


    /**
     * Creates view for each item in the list
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_role, parent, false)
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
     * View for item, sets item info and click roles
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(role: Role, listener: OnItemClickListener) = with(itemView) {
            tv_roleName.text = role.roleName
            setOnClickListener {

                //TODO:: Figure this out later
            }

            // RecyclerView on item click
            setOnClickListener {
                listener.onItemClick(role, it)
            }
        }

    }

}


class RoleListDiffCallback : DiffUtil.ItemCallback<Role>() {
    override fun areItemsTheSame(oldItem: Role, newItem: Role): Boolean {
        return oldItem.roleId == newItem.roleId
    }

    override fun areContentsTheSame(oldItem: Role, newItem: Role): Boolean {
        return oldItem == newItem
    }
}

class RoleListListener(val clickListener: (roleId: Long) -> Unit) {
    fun onClick(role: Role) = clickListener(role.roleId.toLong())
}