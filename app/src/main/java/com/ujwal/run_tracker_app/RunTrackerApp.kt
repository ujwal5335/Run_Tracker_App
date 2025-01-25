package com.ujwal.run_tracker_app

import android.app.Application
import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat
import com.ujwal.auth.data.di.authDataModule
import com.ujwal.auth.presentation.di.authViewModelModule
import com.ujwal.core.data.di.coreDataModule
import com.ujwal.core.database.di.databaseModule
import com.ujwal.run.data.di.runDataModule
import com.ujwal.run.location.di.locationModule
import com.ujwal.run.network.di.networkModule
import com.ujwal.run.presentation.di.runPresentationModule
import com.ujwal.run_tracker_app.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.koin.workManagerFactory
import org.koin.core.context.startKoin
import timber.log.Timber

class RunTrackerApp : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@RunTrackerApp)
            workManagerFactory()
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule,
                databaseModule,
                networkModule,
                runDataModule
            )
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        SplitCompat.install(this)
    }
}