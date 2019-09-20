package net.wetfish.playasoftvolunteers.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import net.wetfish.playasoftvolunteers.data.model.*

/**
 * Created by ${Michael} on 7/27/2019.
 */

@Dao
interface UserDao {
    /**
     * Selection Methods
     */

    @Query("SELECT * FROM UserProfile ORDER BY id DESC")
    fun getUserProfile(): LiveData<UserProfile>

    @Query("SELECT * FROM Event ORDER BY id DESC")
    fun getEvents(): LiveData<List<Event>>

    @Query("SELECT * FROM Department ORDER BY id DESC")
    fun getDepartments(): LiveData<List<Department>>

    @Query("SELECT * FROM Role ORDER BY id DESC")
    fun getRoles(): LiveData<List<Role>>

    @Query("SELECT * FROM Shift ORDER BY id DESC")
    fun getShifts(): LiveData<List<Shift>>

    /**
     * Insertion Methods
     */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserProfile(user: UserProfile)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvents(event: List<Event>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDepartments(department: List<Department>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRoles(role: List<Role>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShifts(shift: List<Shift>)

    /**
     * Deletion Methods
     */

    @Query("DELETE FROM UserProfile")
    fun deleteUserProfile(): UserProfile

    @Query("DELETE FROM Event")
    fun deleteEvents(): List<Event>

    @Query("DELETE FROM Department")
    fun deleteDepartments(): List<Department>

    @Query("DELETE FROM Role")
    fun deleteRoles(): List<Role>

    @Query("DELETE FROM Shift")
    fun deleteShifts(): List<Shift>

    /**
     * ID Selection Methods
     */

    @Query("SELECT * FROM UserProfile WHERE id = :id")
    fun findUserProfile(id: Int): UserProfile

    @Query("SELECT * FROM Event WHERE id = :id")
    fun findEvents(id: Int): List<Event>

    @Query("SELECT * FROM Department WHERE id = :id")
    fun findDepartments(id: Int): List<Department>

    @Query("SELECT * FROM Role WHERE id = :id")
    fun findRoles(id: Int): List<Role>

    @Query("SELECT * FROM Shift WHERE id = :id")
    fun findShifts(id: Int): List<Shift>

    @Query("SELECT * FROM Shift WHERE shiftID = id")
    fun findShift(id: Int): LiveData<Shift>
}