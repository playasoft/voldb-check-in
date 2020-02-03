package net.wetfish.playasoftvolunteers.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Data class that captures userProfile information for logged in users retrieved from LoginRepository
 */

@Entity
data class UserProfile(
    @SerializedName("username")
    @Expose
    var username: String,

    @SerializedName("email")
    @Expose
    var email: String,

    @SerializedName("full_name")
    @Expose
    var fullName: String,

    @SerializedName("burner_name")
    @Expose
    var burnerName: String,

    @SerializedName("phone_number")
    @Expose
    var phoneNumber: String,

    @SerializedName("permissions")
    @Expose
    var permissions: List<String>,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
