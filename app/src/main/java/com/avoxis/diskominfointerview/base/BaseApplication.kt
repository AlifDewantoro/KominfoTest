package com.avoxis.diskominfointerview.base

import android.app.Application
import com.avoxis.diskominfointerview.BuildConfig
import timber.log.Timber

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.e("RUNNING")
        }
    }
}