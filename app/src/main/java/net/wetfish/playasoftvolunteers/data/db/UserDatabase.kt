package net.wetfish.playasoftvolunteers.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import net.wetfish.playasoftvolunteers.data.model.*

/**
 * Created by ${Michael} on 7/29/2019.
 */
@Database(
    entities = arrayOf(
        UserProfile::class,
        UserEvent::class,
        UserEventDepartment::class,
        UserEventDepartmentRole::class,
        UserEventDepartmentRoleShift::class
    ),
    version = 1
)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private val lock = Any()
        private const val DB_NAME = "userInformationDatabase.db"
        private var INSTANCE: UserDatabase? = null

//        fun prePopulate(database: UserDatabase, userProfile: UserProfile) {
//            AsyncTask.execute{database.userDao().insert(userProfile)}
//        }

        fun getInstance(application: Application): UserDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE =
                        Room.databaseBuilder(
                            application,
                            UserDatabase::class.java, DB_NAME)
                            .allowMainThreadQueries()
                            .build()
                }
                return INSTANCE!!
            }
        }
    }
}
