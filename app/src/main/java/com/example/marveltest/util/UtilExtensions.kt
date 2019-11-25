package com.example.marveltest.util

import android.content.Context
import com.example.marveltest.R

fun Double.getAsPrice(context: Context): String {
    return if (this > 0.0) {
        "$$this"
    } else {
        context.getString(R.string.free)
    }
}