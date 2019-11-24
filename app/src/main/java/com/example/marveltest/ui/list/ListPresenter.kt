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

        subscribeToDatabase()
        fetchAndSaveComics()
    }

    private fun subscribeToDatabase() {
        comicsRepository.subscribeToDatabase()
            .onEach {
                view?.showComics(it)
            }
            .onCompletion { throwable ->
                throwable?.let { view?.showError(it) }
            }
            .launchIn(comicsRepository.coroutineMain)
    }

    private fun fetchAndSaveComics() {
        comicsRepository.fetchAndSaveComics()
    }

    companion object {
        const val TAG = "PlayerPresenter"
    }
}