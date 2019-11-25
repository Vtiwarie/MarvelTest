package com.example.marveltest.ui.list

import androidx.annotation.MainThread
import com.example.marveltest.data.entity.Comic
import com.example.marveltest.ui.base.BaseView

interface ListView : BaseView {
    @MainThread
    fun showComicsList(comics: List<Comic>)
}