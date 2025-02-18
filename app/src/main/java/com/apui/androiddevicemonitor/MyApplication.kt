package com.apui.androiddevicemonitor

import android.app.Application
import com.apui.androiddevicemonitor.di.batteryInfoModule
import com.apui.androiddevicemonitor.di.systemInfoModule
import com.apui.androiddevicemonitor.di.topBarViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(topBarViewModelModule, batteryInfoModule, systemInfoModule)
        }
    }
}