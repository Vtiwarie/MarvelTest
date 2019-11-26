package com.example.marveltest.repository

import android.util.Log
import com.example.marveltest.api.NetworkApi
import com.example.marveltest.data.dao.ComicsDao
import com.example.marveltest.data.entity.Comic
import com.example.marveltest.data.entity.ComicDataWrapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.produceIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Class used for storing and retrieving Comics data
 * from either the network or local cache database
 */
open class ComicsRepository @Inject constructor(
    val api: NetworkApi,
    val comicsDao: ComicsDao
) :
    BaseRepository() {

    /**
     * Fetch comics from api and then save results in local cache database
     */
    fun fetchAndSaveComics() {
        coroutineNetwork.launch {
            fetchAndSaveComicsHelper()
        }
    }

    /**
     * Create helper function outside of coroutine so that we can unit test
     */
    suspend fun fetchAndSaveComicsHelper() {
        makeNetworkCall({
            api.fetchComics()
        },
            {
                saveComicsToDatabase(it)
            },
            {
                Log.d(TAG, it.message)
            })
    }

    fun saveComicsToDatabase(comicsDataWrapper: ComicDataWrapper?) {
        val comics = comicsDataWrapper?.data?.results ?: emptyList()
        saveToDatabase { saveAction(comics) }
    }

    fun saveAction(comics: List<Comic>) {
        comicsDao.saveItems(comics)
    }

    fun subscribeToComicsList(): Flow<List<Comic>> {
        return comicsDao.getAll().produceIn(coroutineIO).consumeAsFlow()
    }

    fun subscribeToComic(id: String): Flow<Comic> {
        return comicsDao.get(id).produceIn(coroutineIO).consumeAsFlow()
    }

    companion object {
        const val TAG = "ComicsRepository"
    }
}
