package com.example.marveltest.repository

import android.util.Log
import com.example.marveltest.api.NetworkApi
import com.example.marveltest.data.dao.ComicsDao
import com.example.marveltest.data.entity.Comic
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.produceIn
import javax.inject.Inject

/**
 * Class used for storing and retrieving Comics data
 * from either the network or local cache database
 */
class ComicsRepository @Inject constructor(
    val api: NetworkApi,
    val comicsDao: ComicsDao
) :
    BaseRepository() {

    /**
     * Fetch comics from api and then save results in local cache database
     */
    fun fetchAndSaveComics() {
        makeNetworkCall({
            api.fetchComics()
        },
            {
                val comics = it?.data?.results ?: emptyList()
                saveToDatabase { comicsDao.saveItems(comics) }
            },
            {
                Log.d(TAG, it.message)
            })
    }

    fun subscribeToDatabase(): Flow<List<Comic>> {
        return comicsDao.getAll().produceIn(coroutineIO).consumeAsFlow()
    }


    companion object {
        const val TAG = "ComicsRepository"
    }
}
