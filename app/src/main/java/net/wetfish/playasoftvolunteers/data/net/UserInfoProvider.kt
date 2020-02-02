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
                "Rachel Fish",
                "BlubBlub",
                "555-123-4567",
                listOf("volunteer", "admin", "ranger")
            )

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
                    "Apogaea 2020",
                    "2020-01-01",
                    "2021-01-01"
                )
            )
            events.add(
                Event(
                    "2",
                    "glipglop",
                    "2020-01-01",
                    "2021-01-01"
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
                    "1",
                    "Department #1"
                )
            )
            departments.add(
                Department(
                    "1",
                    "2",
                    "Department #2"
                )
            )
            departments.add(
                Department(
                    "1",
                    "5",
                    "Department #5 test"
                )
            )

            departments.add(
                Department(
                    "2",
                    "3",
                    "Mac"
                )
            )
            departments.add(
                Department(
                    "2",
                    "4",
                    "Kat"
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
                    "1",
                    "1",
                    "Dpt.1 Shift #1"
                )
            )
            roles.add(
                Role(
                    "1",
                    "2",
                    "1",
                    "Dpt.1 Shift #2"

                )
            )
            roles.add(
                Role(
                    "1",
                    "3",
                    "2",
                    "Dpt.1 Shift #1"
                )
            )
            roles.add(
                Role(
                    "1",
                    "4",
                    "2",
                    "Dpt.1 Shift #2"
                )
            )
            roles.add(
                Role(
                    "1",
                    "9",
                    "5",
                    "Dpt. #5 Dog Herder Shift Test"
                )
            )
            roles.add(
                Role(
                    "2",
                    "5",
                    "4",
                    "Shift #1"
                )
            )
            roles.add(
                Role(
                    "2",
                    "6",
                    "4",
                    "Shift #2"
                )
            )
            roles.add(
                Role(
                    "2",
                    "7",
                    "3",
                    "Shift #1 Mac"
                )
            )
            roles.add(
                Role(
                    "2",
                    "8",
                    "3",
                    "Shift #2 Mac"
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

                    "36",
                    "1",
                    "1",
                    "2020-02-01",
                    "2020-02-01",
                    "06:00:00",
                    "15:00:00",
                    "1",
                    "admin@wetfish.net",
                    "Full name",
                    "Temp Display Name",
                    "Temp Status"
                )
            )
            shifts.add(
                Shift(
                    "1",
                    "39",
                    "1",
                    "2",
                    "2020-02-01",
                    "2020-02-01",
                    "06:00:00",
                    "09:00:00",
                    "4",
                    "professional.baird@gmail.com",
                    "Test User Full name",
                    "Temp Display Name",
                    "Temp Status"
                )
            )
            shifts.add(
                Shift(
                    "1",
                    "43",
                    "2",
                    "4",
                    "2020-02-01",
                    "2020-02-01",
                    "06:00:00",
                    "09:00:00",
                    "5",
                    "dominusfarsight@yahoo.com",
                    "Test User Full name",
                    "Temp Display Name",
                    "Temp Status"
                )
            )
            shifts.add(
                Shift(
                    "1",
                    "40",
                    "2",
                    "3",
                    "2020-02-01",
                    "2020-02-01",
                    "06:00:00",
                    "15:00:00",
                    "2",
                    "rachel@wetfish.net",
                    "Temp Full name",
                    "Temp Display Name",
                    "Temp Status"
                )
            )
            shifts.add(
                Shift(
                    "1",
                    "52",
                    "5",
                    "9",
                    "2020-02-01",
                    "2020-02-01",
                    "12:00:00",
                    "18:00:00",
                    "3",
                    "dominuskelenth@gmail.com",
                    "Full name",
                    "Temp Display Name",
                    "Temp Status"
                )
            )
            shifts.add(
                Shift(
                    "2",
                    "44",
                    "4",
                    "5",
                    "2020-02-01",
                    "2020-02-01",
                    "06:00:00",
                    "15:00:00",
                    "1",
                    "admin@wetfish.net",
                    "Full name",
                    "Temp Display Name",
                    "Temp Status"
                )
            )
            shifts.add(
                Shift(
                    "2",
                    "45",
                    "4",
                    "5",
                    "2020-02-01",
                    "2020-02-01",
                    "06:00:00",
                    "15:00:00",
                    "3",
                    "dominuskelenth@gmail.com",
                    "Full name",
                    "Temp Display Name",
                    "Temp Status"
                )
            )
            shifts.add(
                Shift(
                    "2",
                    "47",
                    "4",
                    "6",
                    "2020-02-01",
                    "2020-02-01",
                    "06:00:00",
                    "09:00:00",
                    "4",
                    "professional.baird@gmail.com",
                    "Test User Full name",
                    "Temp Display Name",
                    "Temp Status"
                )
            )
            shifts.add(
                Shift(
                    "2",
                    "51",
                    "3",
                    "8",
                    "2020-02-01",
                    "2020-02-01",
                    "06:00:00",
                    "09:00:00",
                    "5",
                    "dominusfarsight@yahoo.com",
                    "Test User Full name",
                    "Temp Display Name",
                    "Temp Status"
                )
            )
            shifts.add(
                Shift(
                    "2",
                    "48",
                    "3",
                    "7",
                    "2020-02-01",
                    "2020-02-01",
                    "06:00:00",
                    "15:00:00",
                    "2",
                    "rachel@wetfish.net",
                    "Temp Full name",
                    "Temp Display Name",
                    "Temp Status"
                )
            )
            shifts.add(
                Shift(
                    "2",
                    "49",
                    "3",
                    "7",
                    "2020-02-01",
                    "2020-02-01",
                    "06:00:00",
                    "15:00:00",
                    "2",
                    "rachel@wetfish.net",
                    "Temp Full name",
                    "Temp Display Name",
                    "Temp Status"
                )
            )
            return shifts
        }
    }
}