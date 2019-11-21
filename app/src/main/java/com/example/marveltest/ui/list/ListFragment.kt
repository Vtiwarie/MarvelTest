package com.example.irokutest.ui.list

import android.os.Bundle
import com.example.irokutest.App
import com.example.irokutest.MainActivity
import com.example.irokutest.R
import com.example.irokutest.model.Movie
import com.example.irokutest.ui.base.BaseFragment
import com.example.irokutest.ui.detail.DetailFragment
import com.example.irokutest.ui.list.adapter.MovieListAdapter
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : BaseFragment<ListPresenter, ListView>(), ListView {

    override val layoutID = R.layout.fragment_list
    private val movieMovieListAdapter: MovieListAdapter by lazy { MovieListAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.instance.appComponent.inject(this)
    }

    override fun setUpViews() {
        movieMovieListAdapter.clickListener = {
            (activity as? MainActivity)?.navigateToFragment(DetailFragment.newInstance(it.id))
        }
        movie_recycler.adapter = movieMovieListAdapter
    }

    override fun showPopularMovies(movies: List<Movie>) {
        movieMovieListAdapter.submitMovieList(movies)
    }

    override fun showTopMovies(movies: List<Movie>) {
        movieMovieListAdapter.submitMovieList(movies)
    }

    companion object {
        fun newInstance(): ListFragment {
            return ListFragment()
        }
    }
}
