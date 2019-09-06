package net.wetfish.playasoftvolunteers.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_department_list.*
import net.wetfish.playasoftvolunteers.R
import net.wetfish.playasoftvolunteers.data.model.Department
import net.wetfish.playasoftvolunteers.ui.departments.DepartmentListAdapter

/**
 * The Fragment to show the department list
 */
class DepartmentListFragment : Fragment(),
    DepartmentListAdapter.OnItemClickListener {

    private lateinit var viewModel: DepartmentListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

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

        // Start observing event list
        viewModel.getDepartmentList().observe(this, Observer<List<Department>> { departments ->
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
    override fun onItemClick(event: Department, itemView: View) {
        //TODO: Fragment Transactions
    }

}
