package net.wetfish.playasoftvolunteers.ui.roles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_role_list.*
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.db.VolunteerDatabase
import net.wetfish.playasoftvolunteers.data.model.Role
import net.wetfish.playasoftvolunteers.databinding.FragmentRoleListBinding
import net.wetfish.playasoftvolunteers.ui.departments.DepartmentListFragment

/**
 * The Fragment to show the role list
 */
class RoleListFragment : Fragment(),
    RoleListAdapter.OnItemClickListener {

    // Logging Tag
    private val TAG = RoleListFragment::class.qualifiedName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentRoleListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_role_list,
            container,
            false
        )

        val args = RoleListFragmentArgs.fromBundle(arguments!!)

        val application = requireNotNull(this.activity).application

        val dataSource = VolunteerDatabase.getInstance(application).userDao

        val viewModelFactory =
            RoleListViewModelFactory(dataSource, args.departmentId, application)

        val viewModel = ViewModelProviders.of(
            this, viewModelFactory).get(RoleListViewModel::class.java)

        binding.roleListViewModel = viewModel

        binding.setLifecycleOwner {this}

        viewModel.navigateToRoleList.observe(this, Observer {roleId ->
            roleId.let {
                this.findNavController().navigate(
                    RoleListFragmentDirections.actionRoleListFragmentToShiftListFragment(
                        roleId
                    )
                )

                viewModel.doneNavigating()
            }
        })

        return binding.root
    }

}
