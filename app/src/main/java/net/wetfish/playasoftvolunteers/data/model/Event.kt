package net.wetfish.playasoftvolunteers.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by ${Michael} on 8/12/2019.
 */
@Entity
data class Event(
    var event_id: String,
    var name: String,
    var start_date: String,
    var end_date: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)