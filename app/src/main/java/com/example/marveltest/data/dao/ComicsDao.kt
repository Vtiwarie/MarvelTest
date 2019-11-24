package com.example.marveltest.data.dao

import androidx.room.*
import com.example.marveltest.Constants
import com.example.marveltest.data.entity.Comic
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ComicsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun saveItems(list: List<Comic>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun saveItem(comic: Comic)

    @Delete
    abstract fun delete(comic: Comic)

    @Query("SELECT * FROM ${Constants.DB.comicsTableName}")
    abstract fun getAll(): Flow<List<Comic>>
}