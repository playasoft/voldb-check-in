package net.wetfish.playasoftvolunteers.ui.roles

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_list_role_item.view.*
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.model.Role

/**
 * Created by ${Michael} on 8/16/2019.
 */
class RoleListAdapter(
    private val items: List<Role>,
    private val clickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * Notifies click on an item with attached view
     */
    interface OnItemClickListener {
        fun onItemClick(role: Role, itemView: View)
    }

    /**
     * Creates view for each item in the list
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_list_role_item, parent, false)
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