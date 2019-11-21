package com.example.irokutest.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

@Suppress("UNCHECKED_CAST")
fun <T : View> inflateView(
    @LayoutRes layoutResId: Int, parent: ViewGroup,
    attachToRoot: Boolean = false
): T {
    return LayoutInflater.from(parent.context).inflate(layoutResId, parent, attachToRoot) as T
}
