package com.example.marveltest.ui.list

import android.os.Bundle
import com.example.marveltest.MarvelTestApplication
import com.example.marveltest.R
import com.example.marveltest.data.entity.Comic
import com.example.marveltest.ui.base.BaseFragment
import com.example.marveltest.ui.base.BaseNavigator
import com.example.marveltest.ui.detail.DetailFragment
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
        adapter.clickListener = { comic ->
            (activity as? BaseNavigator)?.navigateToFragment(DetailFragment.newInstance(comic.id))
        }
        comic_recycler.adapter = adapter
    }

    override fun showComicsList(comics: List<Comic>) {
        adapter.submitList(comics)
    }

    companion object {
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }
}
