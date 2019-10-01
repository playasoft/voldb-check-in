package net.wetfish.playasoftvolunteers.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

/**
 * Created by ${Michael} on 8/12/2019.
 */
@Parcelize
@Entity
data class Shift(
    var shift_id: String,
    var department_id: String,
    var role_id: String,
    var start_date: String,
    var end_date: String,
    var start_time: String,
    var end_time: String,
    var user_id: String,
    var email: String,
    var full_name: String,
    var display_name: String,
    var status: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
) : Parcelable