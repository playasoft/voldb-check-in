package net.wetfish.playasoftvolunteers.data.db

import android.app.Application
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
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
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class VolunteerDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

//    companion object {
//
//        private const val DB_NAME = "volunteerInformation.db"
//
////        // Singleton
////        @Volatile
////        private var instance: VolunteerDatabase? = null
////
////        fun getInstance(context: Context) : VolunteerDatabase {
////            return instance ?: synchronized(this) {
////                instance ?: buildDatabase(context).also {instance = it}
////            }
////        }
////
////        private fun buildDatabase(context: Context) : VolunteerDatabase {
////            return Room.databaseBuilder(context, VolunteerDatabase::class.java, DB_NAME)
////                .addCallback(object : RoomDatabase.Callback() {
////                    override fun onCreate(db: SupportSQLiteDatabase)  {
////                        super.onCreate(db)
////                        val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
////                        WorkManager.getInstance(context).enqueue(request)
////                    }
////                })
////
////        }
//    }


    // TODO: Delete Later, or delete the other later
    companion object {
        private val lock = Any()
        private const val DB_NAME = "userInformationDatabase.db"
        private var INSTANCE: VolunteerDatabase? = null

        fun prePopulate(
            database: VolunteerDatabase,
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


        fun getInstance(application: Application): VolunteerDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE =
                        Room.databaseBuilder(application, VolunteerDatabase::class.java, DB_NAME)
                            .allowMainThreadQueries()
                            .addCallback(object : Callback() {
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
