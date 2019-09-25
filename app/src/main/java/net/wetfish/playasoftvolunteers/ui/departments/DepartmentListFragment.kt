package net.wetfish.playasoftvolunteers.ui.departments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_department_list.*
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.model.Department

/**
 * The Fragment to show the department list
 */
class DepartmentListFragment : Fragment(),
    DepartmentListAdapter.OnItemClickListener {

    // ViewModel access
    private lateinit var viewModel: DepartmentListViewModel

    // Logging Tag
    private val TAG = DepartmentListFragment::class.qualifiedName


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        // ViewModel initialization
        viewModel = ViewModelProviders.of(this).get(DepartmentListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_department_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Gather the eventID to get the appropriate Departments
        val departmentID = arguments?.getInt(getString(R.string.event_id))

        Log.d(TAG, "YOYOYOYO: " + departmentID)

        // Start observing department list
        viewModel.getDepartmentList(departmentID!!).observe(this, Observer<List<Department>> { departments ->
            departments?.let {
                populateDepartmentList(departments)
            }
        })
    }

    /**
     * Populates peopleRecyclerView with all people info
     */
    private fun populateDepartmentList(departmentList: List<Department>) {
        rv_departments.adapter = DepartmentListAdapter(departmentList, this)
    }

    /**
     * Navigates to people details on item click
     */
    override fun onItemClick(department: Department, itemView: View) {
        // Get the department ID and bundle it for transferring to roles
        val departmentBundle = Bundle().apply {
            putInt(getString(R.string.department_id), (department.departmentID).toInt())
        }

        view?.findNavController()
            ?.navigate(R.id.action_departmentListFragment_to_roleListFragment, departmentBundle)
    }

}
