package com.example.virtusatest.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

class LoadImage {
    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, imageUrl: String?) {
        Picasso.get()
            .load(imageUrl)
            .fit()
            .centerCrop()
            .into(view)
    }
}