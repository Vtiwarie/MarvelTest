package com.example.marveltest.ui.base

interface BaseNavigator {
    fun navigateToFragment(fragment: BaseFragment<*, *>, addToStack: Boolean = true)
}