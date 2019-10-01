package net.wetfish.playasoftvolunteers.ui.roles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_role_list.*
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.model.Role

/**
 * The Fragment to show the role list
 */
class RoleListFragment : Fragment(),
    RoleListAdapter.OnItemClickListener {

    // ViewModel access
    private lateinit var viewModel: RoleListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        // ViewModel initialization
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

        // Gather the role_id to get the appropriate Roles
        val roleID = arguments?.getInt(getString(R.string.department_id))

        // Start observing role list
        viewModel.getRoleList(roleID!!).observe(this, Observer<List<Role>> { roles ->
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
        // Get the role ID and bundle it for transferring to shifts
        val roleBundle = Bundle().apply {
            putInt(getString(R.string.role_id), (role.role_id).toInt())
        }

        view?.findNavController()
            ?.navigate(R.id.action_roleListFragment_to_shiftListFragment, roleBundle)
    }

}
