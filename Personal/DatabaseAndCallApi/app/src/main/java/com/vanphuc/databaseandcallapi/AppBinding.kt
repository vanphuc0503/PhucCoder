package com.vanphuc.databaseandcallapi

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object AppBinding {

    @JvmStatic
    @BindingAdapter("srcImage")
    fun ImageView.srcImage(url: String) {
        Glide
            .with(context)
            .load("$url.png")
            .error(R.drawable.ic_launcher_foreground)
            .placeholder(com.google.android.material.R.drawable.ic_clock_black_24dp)
            .centerInside()
            .centerCrop()
            .into(this);
    }
}