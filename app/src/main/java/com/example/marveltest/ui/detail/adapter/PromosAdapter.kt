package com.example.marveltest.ui.detail.adapter

import android.view.ViewGroup
import com.example.marveltest.data.entity.Image
import com.example.marveltest.ui.base.BaseAdapter

class PromosAdapter : BaseAdapter<Image, PromosViewHolder>() {

    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return false
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return false
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromosViewHolder {
        return PromosViewHolder(parent)
    }

    override fun onBindViewHolder(holder: PromosViewHolder, position: Int) {
        val comic = getItem(position)
        holder.bind(comic)
    }
}