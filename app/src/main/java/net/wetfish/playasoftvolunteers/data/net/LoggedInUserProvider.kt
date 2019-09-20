package net.wetfish.playasoftvolunteers.data.net

import net.wetfish.playasoftvolunteers.data.model.UserProfile

/**
 * Created by ${Michael} on 7/30/2019.
 */
class LoggedInUserProvider {
    companion object {
        var loggedInUser = initLoggedInUser()

        /**
         * Initialize the userProfile
         */
        private fun initLoggedInUser() {
            var user = mutableListOf<UserProfile>()

        }
    }
}