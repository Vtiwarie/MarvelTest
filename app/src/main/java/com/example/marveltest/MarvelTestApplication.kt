package com.example.marveltest

import android.app.Application
import com.example.marveltest.inject.AppComponent
import com.example.marveltest.inject.AppModule

class MarvelTestApplication : Application() {
    lateinit var appComponent: AppComponent
        protected set

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
        appComponent.inject(this)

        Realm.init(this)
    }

    companion object {
        lateinit var instance: MarvelTestApplication
            private set
    }
}
