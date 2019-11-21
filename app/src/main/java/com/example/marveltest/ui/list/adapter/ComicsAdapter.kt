package com.example.marveltest.ui.list.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marveltest.data.entity.Comic
import com.example.marveltest.ui.base.BaseAdapter

class ComicsAdapter : BaseAdapter<Comic, RecyclerView.ViewHolder>() {

    var clickListener: ((Comic) -> Unit)? = null

    override fun areItemsTheSame(oldItem: Comic, newItem: Comic): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Comic, newItem: Comic): Boolean {
        return false
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ComicsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }
}