package com.example.marveltest.ui.detail

import com.example.marveltest.repository.ComicsRepository
import com.example.marveltest.ui.base.BasePresenter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * @author Vishaan Tiwarie
 *
 * Comic Details Presenter
 */
class DetailPresenter @Inject constructor(private val comicsRepository: ComicsRepository) :
    BasePresenter<DetailView>() {

    lateinit var comicId: String

    override fun start() {
        subscribeToComic()
    }

    fun subscribeToComic() {
        comicsRepository.subscribeToComic(comicId)
            .onEach {
                view?.showComicDetails(it)
            }
            .onCompletion { throwable ->
                throwable?.let { view?.showError(it) }
            }
            .launchIn(comicsRepository.coroutineMain)
    }

    companion object {
        const val TAG = "DetailPresenter"
    }
}