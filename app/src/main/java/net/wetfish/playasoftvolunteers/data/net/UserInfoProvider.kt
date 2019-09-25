package net.wetfish.playasoftvolunteers.data.net

import net.wetfish.playasoftvolunteers.data.model.*

/**
 * Created by ${Michael} on 8/16/2019.
 */
class UserInfoProvider {

    companion object {
        var userProfile = initProfile()
        var eventList = initEvents()
        var departmentList = initDepartments()
        var roleList = initRoles()
        var shiftList = initShifts()

        /**
         * Initialises userProfile with dummy data
         */
        private fun initProfile(): UserProfile {
            var userProfile = UserProfile(
                "rachel",
                "rachel@wetfish.net",
                listOf("volunteer", "admin", "ranger"),
                "Rachel Fish",
                "BlubBlub",
                "555-123-4567")

            return userProfile
        }

        /**
         * Initialises eventList with dummy data
         */
        private fun initEvents(): MutableList<Event> {
            var events = mutableListOf<Event>()
            events.add(
                Event(
                    "1",
                    "Apogaea 2017",
                    "2017-06-07",
                    "2017-06-12"
                )
            )
            events.add(
                Event(
                    "2",
                    "Denver Decompression 2018",
                    "2018-10-12",
                    "2018-10-14"
                )
            )
            events.add(
                Event(
                    "3",
                    "Apogaea 2019",
                    "2019-06-05",
                    "2019-06-10"
                )
            )
            return events
        }

        /**
         * Initialises departmentList with dummy data
         */
        private fun initDepartments(): MutableList<Department> {
            var departments = mutableListOf<Department>()
            departments.add(
                Department(
                    "1",
                    "Acculturation"
                )
            )
            departments.add(
                Department(
                    "2",
                    "BAMF"
                )
            )
            departments.add(
                Department(
                    "3",
                    "Cat Herder"
                )
            )
            return departments
        }

        /**
         * Initialises roleList with dummy data
         */
        private fun initRoles(): MutableList<Role> {
            var roles = mutableListOf<Role>()
            roles.add(
                Role(
                    "1",
                    "19",
                    "New Ranger"
                )
            )
            roles.add(
                Role(
                    "2",
                    "19",
                    "Returning Dirt Ranger"
                )
            )
            roles.add(
                Role(
                    "3",
                    "19",
                    "Ranger Khaki"
                )
            )
            return roles
        }

        /**
         * Initialises shiftList with dummy data
         */
        private fun initShifts(): MutableList<Shift> {
            var shifts = mutableListOf<Shift>()
            shifts.add(
                Shift(
                    "1",
                    "5",
                    "10",
                    "2017-06-09",
                    "2017-06-09",
                    "18:00:00",
                    "22:00:00",
                    "1",
                    "cool@volunteer.net",
                    "Volunteer McVolunteererson",
                    "Cool Volunteer",
                    ""
                )
            )
            shifts.add(
                Shift(
                    "2",
                    "5",
                    "10",
                    "2017-06-09",
                    "2017-06-09",
                    "18:00:00",
                    "22:00:00",
                    "2",
                    "friendo@myspace.com",
                    "Buddy Friendo",
                    "Friendo",
                    "flaked"
                )
            )
            shifts.add(
                Shift(
                    "3",
                    "5",
                    "10",
                    "2017-06-09",
                    "2017-06-09",
                    "18:00:00",
                    "22:00:00",
                    "3",
                    "jellyfish@theocean.org",
                    "Pelagia noctiluca",
                    "Jellyfish",
                    "ontime"
                )
            )
            return shifts
        }
    }
}