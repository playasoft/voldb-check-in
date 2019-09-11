package net.wetfish.playasoftvolunteers.ui.roles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_role_list.*
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.model.Role

/**
 * The Fragment to show the role list
 */
class RoleListFragment : Fragment(),
    RoleListAdapter.OnItemClickListener {

    private lateinit var viewModel: RoleListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        viewModel = ViewModelProviders.of(this).get(RoleListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_role_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Start observing role list
        viewModel.getRoleList().observe(this, Observer<List<Role>> { roles ->
            roles?.let {
                populateRoleList(roles)
            }
        })
    }

    /**
     * Populates peopleRecyclerView with all people info
     */
    private fun populateRoleList(roleList: List<Role>) {
        rv_roles.adapter = RoleListAdapter(roleList, this)
    }

    /**
     * Navigates to people details on item click
     */
    override fun onItemClick(role: Role, itemView: View) {
        //TODO: Fragment Transactions
    }

}
