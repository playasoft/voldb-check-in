package net.wetfish.playasoftvolunteers.data.db

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
    fun getUserProfile(): UserProfile

    @Query("SELECT * FROM UserEvent ORDER BY id DESC")
    fun getEvents(): List<UserEvent>

    @Query("SELECT * FROM UserEventDepartment ORDER BY id DESC")
    fun getDepartments(): List<UserEventDepartment>

    @Query("SELECT * FROM UserEventDepartmentRole ORDER BY id DESC")
    fun getRoles(): List<UserEventDepartmentRole>

    @Query("SELECT * FROM UserEventDepartmentRoleShift ORDER BY id DESC")
    fun getShifts(): List<UserEventDepartmentRoleShift>

    /**
     * Insertion Methods
     */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserProfile(user: UserProfile)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertEvents(event: UserEvent)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDepartments(department: UserEventDepartment)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRoles(role: UserEventDepartmentRole)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShifts(shift: UserEventDepartmentRoleShift)

    /**
     * Deletion Methods
     */

    @Query("DELETE FROM UserProfile")
    fun deleteUserProfile(): UserProfile

    @Query("DELETE FROM UserEvent")
    fun deleteEvents(): List<UserEvent>

    @Query("DELETE FROM UserEventDepartment")
    fun deleteDepartments(): List<UserEventDepartment>

    @Query("DELETE FROM UserEventDepartmentRole")
    fun deleteRoles(): List<UserEventDepartmentRole>

    @Query("DELETE FROM UserEventDepartmentRoleShift")
    fun deleteShifts(): List<UserEventDepartmentRoleShift>

    /**
     * ID Selection Methods
     */

    @Query("SELECT * FROM UserProfile WHERE id = :id")
    fun findUserProfile(id: Int): UserProfile

    @Query("SELECT * FROM UserEvent WHERE id = :id")
    fun findEvents(id: Int): List<UserEvent>

    @Query("SELECT * FROM UserEventDepartment WHERE id = :id")
    fun findDepartments(id: Int): List<UserEventDepartment>

    @Query("SELECT * FROM UserEventDepartmentRole WHERE id = :id")
    fun findRoles(id: Int): List<UserEventDepartmentRole>

    @Query("SELECT * FROM UserEventDepartmentRoleShift WHERE id = :id")
    fun findShifts(id: Int): List<UserEventDepartmentRoleShift>
}