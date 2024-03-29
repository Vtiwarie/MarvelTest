package com.example.marveltest.inject

import com.example.marveltest.MainActivity
import com.example.marveltest.MarvelTestApplication
import com.example.marveltest.ui.detail.DetailFragment
import com.example.marveltest.ui.list.ListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class, AppModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(app: MarvelTestApplication)
    fun inject(activity: MainActivity)
    fun inject(fragment: ListFragment)
    fun inject(fragment: DetailFragment)
}