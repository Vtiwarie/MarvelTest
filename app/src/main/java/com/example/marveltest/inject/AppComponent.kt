package com.example.marveltest.inject

import com.example.marveltest.MainActivity
import com.example.marveltest.MarvelTestApplication
import com.example.marveltest.ui.list.ListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, DatabaseModule::class])
interface AppComponent {
    fun inject(app: MarvelTestApplication)
    fun inject(activity: MainActivity)
    fun inject(fragment: ListFragment)
}