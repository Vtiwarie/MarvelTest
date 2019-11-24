package com.example.marveltest.data.entity

import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.marveltest.Constants

@Entity(tableName = Constants.DB.comicsTableName)
data class Comic(
    @PrimaryKey
    @NonNull
    val id: String,
    val title: String?,
    val description: String?,

    @Embedded
    val thumbnail: Image?,

    @Embedded
    val images: ArrayList<Image>?
)