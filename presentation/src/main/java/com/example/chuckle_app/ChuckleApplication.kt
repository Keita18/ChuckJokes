package com.example.chuckle_app

import android.app.Application
import com.example.chuckle_app.di.ApplicationComponent
import com.example.chuckle_app.di.DaggerApplicationComponent
import com.example.chuckle_app.di.modules.ContextModule


class ChuckleApplication: Application() {
    lateinit var applicationComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent
            .builder()
            .contextModule(ContextModule(this))
            .build()

    }
}