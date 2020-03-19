package net.wetfish.playasoftvolunteers.ui.departments

import android.widget.TextView
import androidx.databinding.BindingAdapter
import net.wetfish.playasoftvolunteers.data.model.Department

/**
 *  Binding Adapter for Department Items
 &
 * Created by  on 12/24/2019.
 */
@BindingAdapter("departmentName")
fun TextView.setDepartmentName(item: Department?) {
    item?.let{
        text = item.departmentName
    }
}