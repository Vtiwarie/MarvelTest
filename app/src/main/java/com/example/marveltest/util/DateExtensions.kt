package com.example.marveltest.util

import org.threeten.bp.ZonedDateTime
import org.threeten.bp.format.DateTimeFormatter

fun ZonedDateTime.getFormattedDate(): String {
    val formatter = DateTimeFormatter.ofPattern("MMM dd, YYYY")
    return formatter.format(this)
}