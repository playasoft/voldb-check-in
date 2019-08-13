package net.wetfish.playasoftvolunteers.ui.login

/**
 * Authentication result : success (userProfile details) or error message.
 */
data class LoginResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)
