package net.wetfish.playasoftvolunteers.data

/**
 * Created by ${Michael} on 8/15/2019.
 */
import android.app.Application
import net.wetfish.playasoftvolunteers.data.db.UserDao
import net.wetfish.playasoftvolunteers.data.db.UserDatabase
import net.wetfish.playasoftvolunteers.data.model.*

class PeopleRepository(application: Application) {

    private val userDao: UserDao

    init {
        val userDatabase = UserDatabase.getInstance(application)
        userDao = userDatabase.userDao()
    }

    /**
     * Selection Methods
     */
    fun getUserProfile(): UserProfile {
        return userDao.getUserProfile()
    }

    fun getEvents(): List<UserEvent> {
        return userDao.getEvents()
    }

    fun getDepartments(): List<UserEventDepartment> {
        return userDao.getDepartments()
    }

    fun getRoles(): List<UserEventDepartmentRole> {
        return userDao.getRoles()
    }

    fun getShifts(): List<UserEventDepartmentRoleShift> {
        return getShifts()
    }

    /**
     * Insertion Methods
     */
    fun insertUserProfile(userProfile: UserProfile) {
        return userDao.insertUserProfile(userProfile)
    }

    fun insertEvents(events: List<UserEvent>) {
        return userDao.insertEvents(events)
    }

    fun insertDepartments(departments: List<UserEventDepartment>) {
        return userDao.insertDepartments(departments)
    }

    fun insertRoles(roles: List<UserEventDepartmentRole>)  {
        return userDao.insertRoles(roles)
    }

    fun insertShifts(shifts: List<UserEventDepartmentRoleShift>) {
        return userDao.insertShifts(shifts)
    }

    /**
     * ID Selection Methods
     */
    fun findUserProfile(id: Int): UserProfile {
        return userDao.findUserProfile(id)
    }

    fun findEvents(id: Int): List<UserEvent> {
        return userDao.findEvents(id)
    }

    fun findDepartments(id: Int): List<UserEventDepartment> {
        return userDao.findDepartments(id)
    }

    fun findRoles(id: Int): List<UserEventDepartmentRole> {
        return userDao.findRoles(id)
    }

    fun findShifts(id: Int): List<UserEventDepartmentRoleShift> {
        return userDao.findShifts(id)
    }

}