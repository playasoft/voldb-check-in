package net.wetfish.playasoftvolunteers.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by ${Michael} on 8/12/2019.
 */
@Entity
data class Event(
    var eventID: String,
    var eventName: String,
    var startDate: String,
    var endDate: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)