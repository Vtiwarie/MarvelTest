package com.example.marveltest.ui.detail

import android.os.Bundle
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.marveltest.MarvelTestApplication
import com.example.marveltest.R
import com.example.marveltest.data.entity.Comic
import com.example.marveltest.ui.base.BaseFragment
import com.example.marveltest.ui.detail.adapter.PromosAdapter
import com.example.marveltest.util.getAsPrice
import com.example.marveltest.util.getFormattedDate
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : BaseFragment<DetailPresenter, DetailView>(), DetailView {

    override val layoutID = R.layout.fragment_detail
    private val adapter by lazy { PromosAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MarvelTestApplication.instance.appComponent.inject(this)

        presenter.comicId = arguments?.getString(ARG_COMIC_ID) ?: return
    }

    override fun setUpViews() {
        super.setUpViews()
        promo_recycler.adapter = adapter
    }

    override fun showComicDetails(comic: Comic) {
        //check these mandatory variables so we do not have to use !!
        val view = view ?: return
        val context = context ?: return

        Glide.with(view)
            .load("${comic.thumbnail?.getFullImagePath()}")
            .into(image)

        //get static texts (headers, etc...)
        val byStr = context.getString(R.string.by)
        val pagesStr = context.getString(R.string.pages)
        val releasedStr = context.getString(R.string.released)

        //only display values IF they are not null
        comic.title?.let { title.text = it }
        comic.description?.let { summary.text = it }
        comic.getAuthors()?.takeIf { it.isNotEmpty() }?.let { authors.text = "${byStr}: $it" }
        comic.getPrice()?.let { price.text = it.getAsPrice(context) }
        comic.pageCount?.let { pages.text = "$pagesStr: $it" }
        comic.modified?.let { date.text = "$releasedStr: ${it.getFormattedDate()}" }

        //show the promos and their respective fields ONLY if we actually have promo images to display
        if (comic.images?.isNotEmpty() == true) {
            promo_recycler.isVisible = true
            adapter.submitList(comic.images ?: emptyList())
        } else {
            promo_recycler.isVisible = false
        }

        //only show headers if their corresponding data actually exists
        summary_title.isVisible = comic.description.isNullOrBlank().not()
        promos_title.isVisible = comic.images?.isNotEmpty() == true
    }

    companion object {
        const val ARG_COMIC_ID = "ARG_COMIC_ID"

        fun newInstance(comicId: String): DetailFragment {
            return DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_COMIC_ID, comicId)
                }
            }
        }
    }
}
