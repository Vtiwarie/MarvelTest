package com.example.marveltest.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.marveltest.data.dao.ComicsDao
import com.example.marveltest.data.entity.Comic

@Database(entities = [Comic::class], version = 1)
@TypeConverters(MarvelTypeConverters::class)
abstract class MarvelDatabase : RoomDatabase() {
    abstract fun comicsDao(): ComicsDao
}