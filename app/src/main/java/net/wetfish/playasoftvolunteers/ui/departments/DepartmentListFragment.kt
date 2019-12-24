package net.wetfish.playasoftvolunteers.ui.departments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.db.VolunteerDatabase
import net.wetfish.playasoftvolunteers.databinding.FragmentDepartmentListBinding

/**
 * The Fragment to show the department list
 */
class DepartmentListFragment : Fragment() {

    // Logging Tag
    private val TAG = DepartmentListFragment::class.qualifiedName

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentDepartmentListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_department_list,
            container,
            false
        )

        val arguments = DepartmentListFragmentArgs.fromBundle(arguments!!)

        val application = requireNotNull(this.activity).application

        val dataSource = VolunteerDatabase.getInstance(application).userDao

        val viewModelFactory =
            DepartmentListViewModelFactory(dataSource, arguments.eventId, application)

        val viewModel = ViewModelProviders.of(
            this, viewModelFactory
        ).get(DepartmentListViewModel::class.java)

        binding.departmentListViewModel = viewModel

        binding.setLifecycleOwner(this)

        viewModel.navigateToRoleList.observe(this, Observer { departmentId ->
            departmentId.let {
                this.findNavController().navigate(
                    DepartmentListFragmentDirections.actionDepartmentListFragmentToRoleListFragment(
                        departmentId
                    )
                )

                viewModel.doneNavigating()
            }
        })

        val adapter = DepartmentListAdapter(DepartmentListListener { departmentId ->
            viewModel.onDepartmentItemClicked(departmentId)
        })

        binding.rvDepartments.adapter = adapter

        viewModel.departmentsList.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        return binding.root
    }
}
