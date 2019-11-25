package com.example.marveltest.data

import androidx.room.TypeConverter
import com.example.marveltest.data.entity.ComicPrice
import com.example.marveltest.data.entity.CreatorSummary
import com.example.marveltest.data.entity.Image
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.threeten.bp.ZonedDateTime
import java.util.*


object MarvelTypeConverters {

    @TypeConverter
    @JvmStatic
    fun stringToZonedDateTime(value: String?): ZonedDateTime? {
        return if (value == null) null else ZonedDateTime.parse(value)
    }

    @TypeConverter
    @JvmStatic
    fun zonedDateTimeToString(date: ZonedDateTime?): String? {
        return date.toString()
    }

    @TypeConverter
    @JvmStatic
    fun imageToString(value: ArrayList<Image>?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    @JvmStatic
    fun stringToImage(value: String): ArrayList<Image>? {
        val listType = object : TypeToken<ArrayList<Image>>() {}.getType()
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun priceToString(value: ArrayList<ComicPrice>?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    @JvmStatic
    fun stringToPrice(value: String): ArrayList<ComicPrice>? {
        val listType = object : TypeToken<ArrayList<ComicPrice>>() {}.getType()
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    @JvmStatic
    fun summaryToString(value: ArrayList<CreatorSummary>?): String {
        return Gson().toJson(value)
    }

    @TypeConverter
    @JvmStatic
    fun stringToSummary(value: String): ArrayList<CreatorSummary>? {
        val listType = object : TypeToken<ArrayList<CreatorSummary>>() {}.getType()
        return Gson().fromJson(value, listType)
    }
}