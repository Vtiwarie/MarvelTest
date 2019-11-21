package com.example.irokutest.api

import com.example.irokutest.Constants
import com.example.irokutest.model.MovieResults
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {
    @GET("movie/popular")
    fun fetchPopularMovies(@Query(Constants.Api.apiKey) apiKey: String): Flowable<MovieResults>

    @GET("movie/top_rated")
    fun fetchTopMovies(@Query(Constants.Api.apiKey) apiKey: String): Flowable<MovieResults>
}
