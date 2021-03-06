package net.wetfish.playasoftvolunteers.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by ${Michael} on 8/12/2019.
 */
@Entity
data class Role(
    @SerializedName("event_id")
    @Expose
    var eventId: String,

    @SerializedName("id")
    @Expose
    var roleId: String,

    @SerializedName("department_id")
    @Expose
    var departmentId: String,

    @SerializedName("name")
    @Expose
    var roleName: String,

    @PrimaryKey(autoGenerate = true) var id: Int = 0
)