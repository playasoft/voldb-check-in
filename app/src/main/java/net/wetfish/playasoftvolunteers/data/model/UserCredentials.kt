package net.wetfish.playasoftvolunteers.data.model

/**
 * Created by  on 9/30/2019.
 */
import com.squareup.moshi.JsonClass

/**
 * Created by ${Michael} on 5/23/2019.
 */

@JsonClass(generateAdapter = true)
data class UserCredentials(
    var name: String = "",
    var password: String = "",
    var _token: String = ""
)