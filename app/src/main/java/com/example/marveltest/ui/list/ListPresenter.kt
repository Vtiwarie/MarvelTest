package com.example.marveltest.ui.list

import com.example.marveltest.repository.ComicsRepository
import com.example.marveltest.ui.base.BasePresenter
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * @author Vishaan Tiwarie
 *
 * ListFragment Presenter
 */
class ListPresenter @Inject constructor(private val comicsRepository: ComicsRepository) :
    BasePresenter<ListView>() {

    override fun start() {
        super.start()

        subscribeToComicsList()
        fetchAndSaveComics()
    }

    fun subscribeToComicsList() {
        comicsRepository.subscribeToComicsList()
            .onEach {
                view?.showComicsList(it)
            }
            .onCompletion { throwable ->
                throwable?.let { view?.showError(it) }
            }
            .launchIn(comicsRepository.coroutineMain)
    }

    fun fetchAndSaveComics() {
        comicsRepository.fetchAndSaveComics()
    }

    companion object {
        const val TAG = "PlayerPresenter"
    }
}