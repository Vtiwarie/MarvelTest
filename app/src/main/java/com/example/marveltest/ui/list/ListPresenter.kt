package com.example.marveltest.ui.list

import com.example.marveltest.repository.MovieRepository
import com.example.marveltest.ui.base.BasePresenter
import javax.inject.Inject

/**
 * @author Vishaan Tiwarie
 *
 * ListFragment Presenter
 */
class ListPresenter @Inject constructor(private val movieRepository: MovieRepository) :
    BasePresenter<ListView>() {

    companion object {
        const val TAG = "PlayerPresenter"
    }
}