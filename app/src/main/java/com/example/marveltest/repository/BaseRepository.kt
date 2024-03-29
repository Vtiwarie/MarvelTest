package com.example.marveltest.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

/**
 * Abstract Repository class handles the app's data sources by
 * encapsulating functionality that will be used by all repository classes. Each
 * Repository is responsible for fetching data from the network and updating/reading
 * to and from the local database cache
 */
abstract class BaseRepository {

    //network dispatcher
    val coroutineNetwork = CoroutineScope(Dispatchers.Default)

    //database dispatcher
    val coroutineIO = CoroutineScope(Dispatchers.IO)

    //main thread dispatcher
    val coroutineMain = CoroutineScope(Dispatchers.Main)

    open suspend fun <T> makeNetworkCall(
        call: suspend () -> Response<T>,
        onSuccess: (T?) -> Unit,
        onError: ((Throwable) -> Unit)? = null
    ) {
        val response = call()
        if (response.isSuccessful) {
            onSuccess(response.body())
        } else {
            onError?.invoke(throw Exception(response.errorBody()?.string()))
        }
    }

    open fun saveToDatabase(
        saveAction: suspend () -> Unit
    ) {
        coroutineIO.launch {
            saveAction()
        }
    }
}