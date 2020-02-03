package net.wetfish.playasoftvolunteers

import android.app.Activity
import android.app.Application
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import net.wetfish.playasoftvolunteers.util.CrashReportingTree
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by ${Michael} on 8/17/2019.
 */
class App : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        else Timber.plant(CrashReportingTree())
    }

    /** Returns an [AndroidInjector] of [Activity]s.  */
    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector
    }
