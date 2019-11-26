package com.example.marveltest.api

import android.content.Context
import com.example.marveltest.Constants
import com.example.marveltest.R
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*
import javax.inject.Inject

/**
 *
 */
class AuthInterceptor @Inject constructor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val apiKey = context.getString(R.string.apikey)
        val ts = Date().time.toString()

        val newUrl = request.url().newBuilder()
            .addQueryParameter(Constants.Api.apiKey, apiKey)
            .addQueryParameter(Constants.Api.apiHash, generateHash(context, ts))
            .addQueryParameter(Constants.Api.apiTs, ts)
            .build()

        return chain.proceed(request.newBuilder().url(newUrl).build())
    }

    fun generateHash(context: Context, ts: String): String {
        val privateKey = context.getString(R.string.private_key)
        val apiKey = context.getString(R.string.apikey)

        return com.example.marveltest.util.getMd5(ts + privateKey + apiKey)
    }
}