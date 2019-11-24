package com.example.marveltest.ui.list.adapter

import android.view.ViewGroup
import com.example.marveltest.data.entity.Comic
import com.example.marveltest.ui.base.BaseAdapter

class ComicsAdapter : BaseAdapter<Comic, ComicsViewHolder>() {

    var clickListener: ((Comic) -> Unit)? = null

    override fun areItemsTheSame(oldItem: Comic, newItem: Comic): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Comic, newItem: Comic): Boolean {
        return oldItem.id == newItem.id && oldItem.title == newItem.title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        return ComicsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        val comic = getItem(position)
        holder.bind(comic, clickListener)
    }
}