package com.example.marveltest.repository

import com.example.marveltest.MarvelTestApplication
import com.example.marveltest.R
import com.example.marveltest.api.NetworkApi
import javax.inject.Inject


class MovieRepository @Inject constructor(
    var api: NetworkApi
) :
    BaseRepository() {

}
