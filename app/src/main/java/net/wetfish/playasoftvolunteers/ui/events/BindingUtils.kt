package net.wetfish.playasoftvolunteers.ui.events

import android.widget.TextView
import androidx.databinding.BindingAdapter
import net.wetfish.playasoftvolunteers.data.model.Event

/**
 * BindingAdapter for Event Items
 * Created by ${Michael} on 12/21/2019.
 */
@BindingAdapter("eventName")
fun TextView.setEventName(item: Event?) {
    item?.let{
        text = item.eventName
    }
}

@BindingAdapter("eventStart")
fun TextView.setEventStartDate(item: Event?) {
    item?.let{
        text = item.startDate
    }
}

@BindingAdapter("eventEnd")
fun TextView.setEventEndDate(item: Event?) {
    item?.let{
        text = item.endDate
    }
}


