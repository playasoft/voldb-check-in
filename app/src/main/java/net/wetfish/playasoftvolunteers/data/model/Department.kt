package net.wetfish.playasoftvolunteers.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by ${Michael} on 8/12/2019.
 */
@Entity
data class Department(
    var department_id: String,
    var name: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)