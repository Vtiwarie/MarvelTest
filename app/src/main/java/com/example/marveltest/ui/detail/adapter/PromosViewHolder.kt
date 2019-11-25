package com.example.marveltest.ui.detail.adapter

import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.marveltest.R
import com.example.marveltest.data.entity.Image
import com.example.marveltest.ui.base.BaseViewHolder
import com.example.marveltest.util.inflateView

class PromosViewHolder(parent: ViewGroup) :
    BaseViewHolder(inflateView(R.layout.item_comic_promo, parent, false)) {

    fun bind(promoImage: Image) {

        val image = itemView.findViewById<ImageView>(R.id.image)

        Glide.with(itemView)
            .load("${promoImage.getFullImagePath()}")
            .into(image)
    }
}