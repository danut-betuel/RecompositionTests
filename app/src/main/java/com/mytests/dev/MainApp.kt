package com.mytests.dev

import android.app.Application
import com.mytests.dev.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApp)
            androidLogger(Level.NONE)
            modules(
                listOf(
                    presentationModule,
                )
            )
        }
    }

}