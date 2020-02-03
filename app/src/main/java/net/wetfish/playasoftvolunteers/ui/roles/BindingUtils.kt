package net.wetfish.playasoftvolunteers.ui.roles

import android.widget.TextView
import androidx.databinding.BindingAdapter
import net.wetfish.playasoftvolunteers.data.model.Role

/**
 * Binding Adapter for Role items
 *
 * Created by ${Michael} on 12/24/2019.
 */
@BindingAdapter("roleName")
fun TextView.setRoleName(item: Role?) {
    item?.let{
        text = item.roleName
    }
}