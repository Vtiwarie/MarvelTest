package com.example.marveltest.api

import com.example.marveltest.data.entity.ComicDataWrapper
import retrofit2.Response
import retrofit2.http.GET

interface NetworkApi {
    @GET("v1/public/comics")
    suspend fun fetchComics(): Response<ComicDataWrapper>
}
