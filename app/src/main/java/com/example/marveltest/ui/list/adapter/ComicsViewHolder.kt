package com.example.marveltest.ui.list.adapter

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.marveltest.R
import com.example.marveltest.data.entity.Comic
import com.example.marveltest.ui.base.BaseViewHolder
import com.example.marveltest.util.inflateView

class ComicsViewHolder(parent: ViewGroup) :
    BaseViewHolder(inflateView(R.layout.item_comic, parent, false)) {

    fun bind(comic: Comic, listener: ((movie: Comic) -> Unit)? = null) {

        val image = itemView.findViewById<ImageView>(R.id.image)
        val title = itemView.findViewById<TextView>(R.id.title)

        Glide.with(itemView)
            .load("${comic.thumbnail?.getFullImagePath()}")
            .into(image)

        title.text = comic.title

        itemView.setOnClickListener {
            listener?.invoke(comic)
        }
    }
}