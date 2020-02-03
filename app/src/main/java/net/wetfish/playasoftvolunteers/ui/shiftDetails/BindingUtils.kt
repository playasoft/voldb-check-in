package net.wetfish.playasoftvolunteers.ui.shiftDetails

import android.widget.TextView
import androidx.databinding.BindingAdapter
import net.wetfish.playasoftvolunteers.data.model.Shift

/**
 * Created by ${Michael} on 12/30/2019.
 */

@BindingAdapter("shift_id")
fun TextView.setShiftId(item: Shift?) {
    item?.let{
        text  = item.shiftId
    }
}

@BindingAdapter("department_id")
fun TextView.setDepartmentId(item: Shift?) {
    item?.let{
        text  = item.departmentId
    }
}

@BindingAdapter("role_id")
fun TextView.setRoleId(item: Shift?) {
    item?.let{
        text  = item.roleId
    }
}

@BindingAdapter("start_date")
fun TextView.setStartDate(item: Shift?) {
    item?.let{
        text  = item.startDate
    }
}

@BindingAdapter("end_date")
fun TextView.setEndDate(item: Shift?) {
    item?.let{
        text  = item.endDate
    }
}

@BindingAdapter("start_time")
fun TextView.setStartTime(item: Shift?) {
    item?.let{
        text  = item.startTime
    }
}

@BindingAdapter("end_time")
fun TextView.setEndTime(item: Shift?) {
    item?.let{
        text  = item.endTime
    }
}

@BindingAdapter("user_id")
fun TextView.setUserId(item: Shift?) {
    item?.let{
        text  = item.userId
    }
}

@BindingAdapter("email")
fun TextView.setEmail(item: Shift?) {
    item?.let{
        text  = item.email
    }
}

@BindingAdapter("full_name")
fun TextView.setFullName(item: Shift?) {
    item?.let{
        text  = item.fullName
    }
}

@BindingAdapter("display_name")
fun TextView.setDisplayName(item: Shift?) {
    item?.let{
        text  = item.displayName
    }
}
@BindingAdapter("status")
fun TextView.setStatus(item: Shift?) {
    item?.let{
        text  = item.status
    }
}

//TODO: Setup spinner later
