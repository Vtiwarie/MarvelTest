package com.example.irokutest.ui.list

import com.example.irokutest.model.Movie
import com.example.irokutest.ui.base.BaseView

interface ListView : BaseView {
    fun showPopularMovies(movies: List<Movie>)
    fun showTopMovies(movies: List<Movie>)
}