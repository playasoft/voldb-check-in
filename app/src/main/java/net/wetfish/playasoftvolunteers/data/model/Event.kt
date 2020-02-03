package net.wetfish.playasoftvolunteers.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by ${Michael} on 8/12/2019.
 */
@Entity
data class Event(

    @SerializedName("id")
    @Expose
    var eventId: String,

    @SerializedName("name")
    @Expose
    var eventName: String,

    @SerializedName("start_date")
    @Expose
    var startDate: String,

    @SerializedName("end_date")
    @Expose
    var endDate: String,

    @PrimaryKey(autoGenerate = true) var id: Int = 0
)