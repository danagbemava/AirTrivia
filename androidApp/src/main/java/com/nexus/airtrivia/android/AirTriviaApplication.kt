package com.nexus.airtrivia.android

import android.app.Application
import com.nexus.airtrivia.android.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AirTriviaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AirTriviaApplication)
            modules(appModule)
        }
    }
}