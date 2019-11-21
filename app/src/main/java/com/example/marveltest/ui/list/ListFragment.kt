package com.example.marveltest.ui.list

import android.os.Bundle
import com.example.marveltest.MarvelTestApplication
import com.example.marveltest.R
import com.example.marveltest.ui.base.BaseFragment
import com.example.marveltest.ui.list.adapter.ComicsAdapter
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : BaseFragment<ListPresenter, ListView>(), ListView {

    override val layoutID = R.layout.fragment_list
    private val adapter: ComicsAdapter by lazy { ComicsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MarvelTestApplication.instance.appComponent.inject(this)
    }

    override fun setUpViews() {
        adapter.clickListener = {
        }
        movie_recycler.adapter = adapter
    }

    companion object {
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }
}
