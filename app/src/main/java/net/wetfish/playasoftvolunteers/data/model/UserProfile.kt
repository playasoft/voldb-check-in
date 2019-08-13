package net.wetfish.playasoftvolunteers.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data class that captures userProfile information for logged in users retrieved from LoginRepository
 */

@Entity
data class UserProfile(
    var username: String,
    var email: String,
    var permissons: String,
    var fullName: String,
    var burnerName: String,
    var phoneNumber: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
