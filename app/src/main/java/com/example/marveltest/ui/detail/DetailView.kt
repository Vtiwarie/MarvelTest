package com.example.marveltest.ui.detail

import com.example.marveltest.data.entity.Comic
import com.example.marveltest.ui.base.BaseView


interface DetailView : BaseView {
    fun showComicDetails(comic: Comic)
}