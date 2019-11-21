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
    fun provideDatabase(context: Context): MarvelDatabase =
        Room.databaseBuilder(context, MarvelDatabase::class.java, Constants.DB.databaseName).build()

    @Singleton
    @Provides
    fun provideComicsDao(database: MarvelDatabase) = database.comicsDao()

}