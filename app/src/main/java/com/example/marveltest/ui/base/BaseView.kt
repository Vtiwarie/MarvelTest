package com.example.marveltest.ui.base

import androidx.annotation.MainThread

interface BaseView {
    @MainThread
    fun showError(t: Throwable) {}
}