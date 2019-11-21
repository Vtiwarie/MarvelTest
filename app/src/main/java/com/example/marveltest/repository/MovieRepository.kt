package com.example.irokutest.repository

import com.example.irokutest.App
import com.example.irokutest.Constants
import com.example.irokutest.R
import com.example.irokutest.api.NetworkApi
import com.example.irokutest.model.Movie
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MovieRepository @Inject constructor(
    var api: NetworkApi
) :
    BaseRepository() {

    private val apiKey = App.instance.resources.getString(R.string.api_key)

    fun fetchPopularMovies() = api.fetchPopularMovies(apiKey)
        .subscribeOn(Schedulers.newThread())
        .observeOn(Schedulers.io())


    fun fetchTopMovies() = api.fetchTopMovies(apiKey)
        .subscribeOn(Schedulers.newThread())
        .observeOn(Schedulers.io())


    fun getPopularMovies(): Flowable<List<Movie>> {
        return getRealm().where(Movie::class.java)
            .findAllAsync()
            .asFlowable()
            .map { getRealm().copyFromRealm(it) }
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getTopMovies(): Flowable<List<Movie>> {
        return getRealm().where(Movie::class.java)
            .findAllAsync()
            .asFlowable()
            .map { getRealm().copyFromRealm(it) }
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getMovie(id: Int): Movie? {
        return getRealm().where(Movie::class.java)
            .equalTo(Constants.Parameter.id, id)
            .findFirst()
    }
}
