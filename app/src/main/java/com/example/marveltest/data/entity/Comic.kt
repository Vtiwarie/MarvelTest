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
    val title: String?,
    val description: String?,
    val pageCount: Int?,
    val modified: ZonedDateTime?,

    @Embedded
    val thumbnail: Image?,

    @Embedded
    val creators: CreatorList?
) {
    var images: ArrayList<Image>? = null
    var prices: ArrayList<ComicPrice>? = null

    fun getPrice() = prices?.firstOrNull()?.price
    fun getAuthors() =
        creators?.items?.joinToString(separator = ", ", transform = { it.name ?: "" })
}