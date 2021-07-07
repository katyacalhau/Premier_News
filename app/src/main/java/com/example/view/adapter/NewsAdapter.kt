package com.example.view.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.model.Article
import com.example.view.R
import com.squareup.picasso.Picasso

class NewsAdapter(
    private val list: MutableList<Article>,
    private val context: Context
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.card_recycler, parent)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news: Article = list.elementAt(position)
        Picasso.get().load(news.urlToImage).into(holder.notice_image)

    }

    inner class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val notice_image by lazy { view.findViewById<ImageView>(R.id.img_news) }
        val notice_name by lazy { view.findViewById<TextView>(R.id.text_title) }
        val notice_card by lazy { view.findViewById<TextView>(R.id.cardview) }
        val notice_text by lazy { view.findViewById<TextView>(R.id.text_description_notice) }

    }


    override fun getItemCount(): Int {
        return list.size
    }


}