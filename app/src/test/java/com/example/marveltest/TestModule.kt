package com.example.marveltest

import android.app.Application
import com.example.marveltest.data.dao.ComicsDao
import com.example.marveltest.inject.AppModule
import dagger.Module
import dagger.Provides

@Module
class TestModule(
    application: Application,
    private val comicsDao: ComicsDao
) : AppModule(application) {

    @Provides
    fun provideComicsDao(): ComicsDao {
        return comicsDao
    }
}
