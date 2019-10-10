package net.wetfish.playasoftvolunteers.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by ${Michael} on 8/12/2019.
 */
@Parcelize
@Entity
data class Shift(
    @SerializedName("shift_id")
    @Expose
    var shiftId: String,

    @SerializedName("department_id")
    @Expose
    var departmentId: String,

    @SerializedName("role_id")
    @Expose
    var roleId: String,

    @SerializedName("start_date")
    @Expose
    var startDate: String,

    @SerializedName("end_date")
    @Expose
    var endDate: String,

    @SerializedName("start_time")
    @Expose
    var startTime: String,

    @SerializedName("end_time")
    @Expose
    var endTime: String,

    @SerializedName("user_id")
    @Expose
    var userId: String,

    @SerializedName("email")
    @Expose
    var email: String,

    @SerializedName("full_name")
    @Expose
    var fullName: String,

//    @SerializedName("display_name")
//    @Expose
//    var displayName: String,

    @SerializedName("status")
    @Expose
    var status: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
) : Parcelable