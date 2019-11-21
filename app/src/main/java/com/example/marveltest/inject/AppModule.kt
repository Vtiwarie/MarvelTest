package com.example.marveltest.inject

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
open class AppModule(private var application: Application) {
    
    @Provides
    @Singleton
    @ForApplication
    fun provideContext(): Context {
        return application
    }
}
