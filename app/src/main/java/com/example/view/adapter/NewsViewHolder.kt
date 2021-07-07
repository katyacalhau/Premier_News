package com.example.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.view.R

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val cardView = view.findViewById<CardView>(R.id.card_recycler)
    val image = view.findViewById<ImageView>(R.id.image_notice_card)
    var name = view.findViewById<TextView>(R.id.text_card)
    var description = view.findViewById<TextView>(R.id.text_description_card)
}

