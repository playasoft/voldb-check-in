package net.wetfish.playasoftvolunteers.data

/**
 * Created by ${Michael} on 8/15/2019.
 */
import android.app.Application
import androidx.lifecycle.LiveData
import net.wetfish.playasoftvolunteers.data.db.UserDao
import net.wetfish.playasoftvolunteers.data.db.UserDatabase
import net.wetfish.playasoftvolunteers.data.model.*

class UserInfoRepository(application: Application) {

    private val userDao: UserDao

    init {
        val userDatabase = UserDatabase.getInstance(application)
        userDao = userDatabase.userDao()
    }

    /**
     * Selection Methods
     */
    fun getUserProfile(): LiveData<UserProfile> {
        return userDao.getUserProfile()
    }

    fun getEvents(): LiveData<List<Event>> {
        return userDao.getEvents()
    }

    fun getDepartments(): LiveData<List<Department>> {
        return userDao.getDepartments()
    }

    fun getRoles(): LiveData<List<Role>> {
        return userDao.getRoles()
    }

    fun getShifts(): LiveData<List<Shift>> {
        return userDao.getShifts()
    }

    /**
     * Insertion Methods
     */
    fun insertUserProfile(userProfile: UserProfile) {
        return userDao.insertUserProfile(userProfile)
    }

    fun insertEvents(events: List<Event>) {
        return userDao.insertEvents(events)
    }

    fun insertDepartments(departments: List<Department>) {
        return userDao.insertDepartments(departments)
    }

    fun insertRoles(roles: List<Role>)  {
        return userDao.insertRoles(roles)
    }

    fun insertShifts(shifts: List<Shift>) {
        return userDao.insertShifts(shifts)
    }

    /**
     * ID Selection Methods
     */
    fun findUserProfile(id: Int): UserProfile {
        return userDao.findUserProfile(id)
    }

    fun findEvents(id: Int): List<Event> {
        return userDao.findEvents(id)
    }

    fun findDepartments(id: Int): List<Department> {
        return userDao.findDepartments(id)
    }

    fun findRoles(id: Int): List<Role> {
        return userDao.findRoles(id)
    }

    fun findShifts(id: Int): List<Shift> {
        return userDao.findShifts(id)
    }

}