package com.example.marveltest


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marveltest.ui.base.BaseFragment
import com.example.marveltest.ui.base.BaseNavigator
import com.example.marveltest.ui.list.ListFragment

class MainActivity : AppCompatActivity(), BaseNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MarvelTestApplication.instance.appComponent.inject(this)
        setContentView(R.layout.activity_main)

        //starting fragment
        navigateToFragment(ListFragment.newInstance(), false)
    }

    //very basic navigation for simple app
    override fun navigateToFragment(fragment: BaseFragment<*, *>, addToStack: Boolean) {
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
