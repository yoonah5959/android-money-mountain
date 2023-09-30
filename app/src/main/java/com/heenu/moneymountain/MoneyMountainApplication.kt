package com.heenu.moneymountain

import android.app.Application
import timber.log.Timber

class MoneyMountainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.isDebug) {
            Timber.plant(Timber.DebugTree())
        }
    }
}