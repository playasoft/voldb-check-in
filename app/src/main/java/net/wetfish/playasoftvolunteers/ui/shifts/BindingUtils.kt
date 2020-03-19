package net.wetfish.playasoftvolunteers.ui.shifts

import android.widget.TextView
import androidx.databinding.BindingAdapter
import net.wetfish.playasoftvolunteers.data.model.Shift

/**
 * Created by ${Michael} on 12/24/2019.
 */

@BindingAdapter("shiftStartDate")
fun TextView.setShiftStartDate(item: Shift?) {
    item?.let{
        text = item.startDate
    }
}

@BindingAdapter("shiftEndDate")
fun TextView.setShiftEndDate(item: Shift?) {
    item?.let{
        text = item.endDate
    }
}

@BindingAdapter("shiftStartTime")
fun TextView.setShiftStartTime(item: Shift?) {
    item?.let{
        text = item.startTime
    }
}

@BindingAdapter("shiftEndTime")
fun TextView.setShiftEndTime(item: Shift?) {
    item?.let{
        text = item.endTime
    }
}

@BindingAdapter("shiftFullName")
fun TextView.setShiftFullName(item: Shift?) {
    item?.let{
        text = item.fullName
    }
}

@BindingAdapter("shiftDisplayName")
fun TextView.setShiftDisplayName(item: Shift?) {
    item?.let{
        text = item.displayName
    }
}

@BindingAdapter("shiftStatus")
fun TextView.setShiftStatus(item: Shift?) {
    item?.let{
        text = item.status
    }
}