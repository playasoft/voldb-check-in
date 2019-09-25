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
    var shiftID: String,
    var departmentID: String,
    var roleID: String,
    var startDate: String,
    var endDate: String,
    var startTime: String,
    var endTime: String,
    var userID: String,
    var email: String,
    var fullName: String,
    var displayName: String,
    var status: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
) : Parcelable