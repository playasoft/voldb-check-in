package net.wetfish.playasoftvolunteers.data.db

import android.app.Application
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import net.wetfish.playasoftvolunteers.data.model.*
import net.wetfish.playasoftvolunteers.data.net.UserInfoProvider

/**
 * Created by ${Michael} on 7/29/2019.
 */
@Database(
    entities = arrayOf(
        UserProfile::class,
        Event::class,
        Department::class,
        Role::class,
        Shift::class
    ),
    version = 1
)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private val lock = Any()
        private const val DB_NAME = "userInformationDatabase.db"
        private var INSTANCE: UserDatabase? = null

        fun prePopulate(
            database: UserDatabase,
            userProfile: UserProfile,
            events: List<Event>,
            departments: List<Department>,
            roles: List<Role>,
            shifts: List<Shift>
        ) {
            AsyncTask.execute { database.userDao().insertUserProfile(userProfile) }
            AsyncTask.execute { database.userDao().insertEvents(events) }
            AsyncTask.execute { database.userDao().insertDepartments(departments) }
            AsyncTask.execute { database.userDao().insertRoles(roles) }
            AsyncTask.execute { database.userDao().insertShifts(shifts) }
        }


        fun getInstance(application: Application): UserDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE =
                        Room.databaseBuilder(application, UserDatabase::class.java, DB_NAME)
                            .allowMainThreadQueries()
                            .addCallback(object : RoomDatabase.Callback() {
                                override fun onCreate(db: SupportSQLiteDatabase) {
                                    super.onCreate(db)
                                    INSTANCE?.let {
                                        prePopulate(
                                            it, UserInfoProvider.userProfile,
                                            UserInfoProvider.eventList,
                                            UserInfoProvider.departmentList,
                                            UserInfoProvider.roleList,
                                            UserInfoProvider.shiftList
                                        )
                                    }
                                }
                            })
                            .build()
                }
                return INSTANCE!!
            }
        }
    }
}
