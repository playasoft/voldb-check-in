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
    var permissons: List<String>,
    var full_name: String,
    var burner_name: String,
    var phone_number: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
