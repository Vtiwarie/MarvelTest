package com.example.marveltest.util

import android.content.Context
import com.example.marveltest.R
import java.text.NumberFormat

/**
 * Format price with 2 trailing fractional digits
 *
 * Will need to change this if we are working with foreign countries
 * and use their currency display defaults
 */
fun Double.getAsPrice(context: Context): String {
    return if (this > 0.0) {
        val formattedPrice =
            NumberFormat.getInstance().apply { minimumFractionDigits = 2 }.format(this)
        "$$formattedPrice"
    } else {
        context.getString(R.string.free)
    }
}