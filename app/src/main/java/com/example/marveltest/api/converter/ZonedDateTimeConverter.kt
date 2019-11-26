package com.example.marveltest.api.converter

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import org.threeten.bp.ZonedDateTime
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*

/**
 * @class ZonedDateTimeConverter
 *
 * Used to parse the dates that come from the Marvel Comics API
 */
class ZonedDateTimeConverter : JsonDeserializer<ZonedDateTime> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): ZonedDateTime {
        val dateString =
            json?.asString?.replace("-000\\d".toRegex(), SimpleDateFormat("YYYY").format(Date()))
                ?.replace("-0\\d00".toRegex(), "Z")

        return ZonedDateTime.parse(dateString)
    }
}