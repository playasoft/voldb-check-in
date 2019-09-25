package net.wetfish.playasoftvolunteers.data

import net.wetfish.playasoftvolunteers.data.model.UserProfile
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves userProfile information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<UserProfile> {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = UserProfile(java.util.UUID.randomUUID().toString(), "Jane Doe", listOf("f"), "f", "f", "f")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e) as Exception)
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}

