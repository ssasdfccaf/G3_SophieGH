package com.example.androidscaffolding.ui.Main.MyPage.ViewHolder

import android.R
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var text: TextView
    //var iv_movie: ImageView

    init {
       //iv_movie = itemView.findViewById<ImageView>(R.id.iv_movie)
        text = itemView.findViewById<TextView>(R.id.text1)
    }

    //fun onBind(data: DataMovie) {
        //tv_movie_title.text = data.title
       // iv_movie.setImageResource(data.getImage())
    }
