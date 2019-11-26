package com.example.marveltest

import com.example.marveltest.inject.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TestModule::class, NetworkModule::class])
interface TestComponent {
    fun inject(listPresenterTest: ListPresenterTest)
}