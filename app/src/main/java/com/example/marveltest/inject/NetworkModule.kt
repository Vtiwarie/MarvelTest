package com.example.marveltest.inject

import android.content.Context
import com.example.marveltest.R
import com.example.marveltest.api.AuthInterceptor
import com.example.marveltest.api.NetworkApi
import com.example.marveltest.api.converter.ZonedDateTimeConverter
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.threeten.bp.ZonedDateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun provideApiKeyInterceptor(@ForApplication context: Context): AuthInterceptor {
        return AuthInterceptor(context)
    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    @Provides
    @Singleton
    fun provideHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: AuthInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(authInterceptor)
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(
            GsonBuilder()
                .registerTypeAdapter(ZonedDateTime::class.java, ZonedDateTimeConverter())
                .create()
        )
    }

    @Provides
    @Singleton
    fun provideApi(
        @ForApplication context: Context,
        httpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): NetworkApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(context.getString(R.string.base_url))
            .addConverterFactory(gsonConverterFactory)
            .client(httpClient)
            .build()
        return retrofit.create(NetworkApi::class.java)
    }
}
