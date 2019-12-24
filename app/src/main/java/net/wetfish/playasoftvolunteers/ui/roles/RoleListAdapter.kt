package net.wetfish.playasoftvolunteers.ui.roles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import net.wetfish.playasoftvolunteers.data.model.Role
import net.wetfish.playasoftvolunteers.databinding.ListItemRoleBinding

/**
 * Created by ${Michael} on 8/16/2019.
 */
class RoleListAdapter(val clickListener: RoleListListener) :
    ListAdapter<Role, RoleListAdapter.ViewHolder>(RoleListDiffCallback()) {


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
     * View for item, sets item info and click roles
     */
    class ViewHolder private constructor(val binding: ListItemRoleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(role: Role, clickListener: RoleListListener) {
            binding.role = role
            binding.clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemRoleBinding.inflate(layoutInflater,  parent, false)
                return ViewHolder(binding)
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