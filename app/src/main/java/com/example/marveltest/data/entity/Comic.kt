package com.example.marveltest.data.entity

import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.marveltest.Constants
import org.threeten.bp.ZonedDateTime
import java.util.*

@Entity(tableName = Constants.DB.comicsTableName)
data class Comic(
    @PrimaryKey
    @NonNull
    val id: String,
    val title: String? = null,
    val description: String? = null,
    val pageCount: Int? = null,
    val modified: ZonedDateTime? = null,

    @Embedded
    val thumbnail: Image? = null,

    @Embedded
    val creators: CreatorList? = null
) {
    var images: ArrayList<Image>? = null
    var prices: ArrayList<ComicPrice>? = null

    fun getPrice() = prices?.firstOrNull()?.price

    fun getAuthors() =
        creators?.items?.joinToString(separator = ", ", transform = { it.name ?: "" })
}