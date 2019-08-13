package net.wetfish.playasoftvolunteers.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by ${Michael} on 8/12/2019.
 */
@Entity
data class UserEventDepartmentRoleShifts(
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
)