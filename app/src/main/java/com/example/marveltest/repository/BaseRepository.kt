package com.example.marveltest.repository

import com.example.marveltest.MarvelTestApplication
import com.example.marveltest.R


abstract class BaseRepository {
    protected val apiKey = MarvelTestApplication.instance.resources.getString(R.string.api_key)

}