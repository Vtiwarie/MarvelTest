package com.example.marveltest.inject

import android.content.Context
import androidx.room.Room
import com.example.marveltest.Constants
import com.example.marveltest.data.MarvelDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ForApplication context: Context): MarvelDatabase =
        Room.databaseBuilder(context.applicationContext, MarvelDatabase::class.java, Constants.DB.databaseName).build()

    @Provides
    fun provideComicsDao(database: MarvelDatabase) = database.comicsDao()

}