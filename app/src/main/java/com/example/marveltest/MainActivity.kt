package com.example.marveltest


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marveltest.ui.base.BaseFragment
import com.example.marveltest.ui.list.ListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MarvelTestApplication.instance.appComponent.inject(this)
        setContentView(R.layout.activity_main)

        //starting fragment
        navigateToFragment(ListFragment.newInstance(), false)
    }

    fun navigateToFragment(fragment: BaseFragment<*, *>, addToStack: Boolean = true) {
        supportFragmentManager.beginTransaction()
            .replace(CONTAINER, fragment).apply {
                if (addToStack) {
                    this.addToBackStack(null)
                }
            }
            .commit()
    }

    companion object {
        const val CONTAINER = R.id.container
    }
}
