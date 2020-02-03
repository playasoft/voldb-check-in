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
        text  = item.eventId
    }
}

@BindingAdapter("department_id")
fun TextView.setDepartmentId(item: Shift?) {
    item?.let{
        text  = item.eventId
    }
}

@BindingAdapter("role_id")
fun TextView.setRoleId(item: Shift?) {
    item?.let{
        text  = item.eventId
    }
}

@BindingAdapter("start_date")
fun TextView.setStartDate(item: Shift?) {
    item?.let{
        text  = item.eventId
    }
}

@BindingAdapter("end_date")
fun TextView.setEndDate(item: Shift?) {
    item?.let{
        text  = item.eventId
    }
}

@BindingAdapter("start_time")
fun TextView.setStartTime(item: Shift?) {
    item?.let{
        text  = item.eventId
    }
}

@BindingAdapter("end_time")
fun TextView.setEndTime(item: Shift?) {
    item?.let{
        text  = item.eventId
    }
}

@BindingAdapter("user_id")
fun TextView.setUserId(item: Shift?) {
    item?.let{
        text  = item.eventId
    }
}

@BindingAdapter("email")
fun TextView.setEmail(item: Shift?) {
    item?.let{
        text  = item.eventId
    }
}

@BindingAdapter("full_name")
fun TextView.setFullName(item: Shift?) {
    item?.let{
        text  = item.eventId
    }
}

@BindingAdapter("display_name")
fun TextView.setDisplayName(item: Shift?) {
    item?.let{
        text  = item.eventId
    }
}
@BindingAdapter("status")
fun TextView.setStatus(item: Shift?) {
    item?.let{
        text  = item.eventId
    }
}

//TODO: Setup spinner later
//@BindingAdapter("onItemSelected")
//fun Spinner.setItemSelectedListener(itemSelectedListener: ItemSelectedListener?) {
//    setSpinnerItemSelectedListener(itemSelectedListener)
//}

//@BindingAdapter("newValue")
//fun Spinner.setNewValue(newValue: Any?) {
//    setSpinnerValue(newValue)
//}