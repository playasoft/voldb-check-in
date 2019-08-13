package net.wetfish.playasoftvolunteers.data

import net.wetfish.playasoftvolunteers.data.model.UserProfile

/**
 * Class that requests authentication and userProfile information from the remote data source and
 * maintains an in-memory cache of login status and userProfile credentials information.
 */

class LoginRepository(val dataSource: LoginDataSource) {

    // in-memory cache of the loggedInUser object
    var userProfile: UserProfile? = null
        private set

    val isLoggedIn: Boolean
        get() = userProfile != null

    init {
        // If userProfile credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        userProfile = null
    }

    fun logout() {
        userProfile = null
        dataSource.logout()
    }

    fun login(username: String, password: String): Result<UserProfile> {
        // handle login
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(userProfile: UserProfile) {
        this.userProfile = userProfile
        // If userProfile credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}
