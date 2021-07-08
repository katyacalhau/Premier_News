package com.example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.model.Article
import com.example.view.adapter.NewsAdapter
import com.example.viewmodel.ViewModelNews

class MainActivity : AppCompatActivity() {
    private var article: MutableList<Article> = mutableListOf<Article>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recycler_home)

        val viewModelNews = ViewModelProviders.of(this).get(ViewModelNews::class.java)

        val adapterNews = NewsAdapter(article, this)
        recycler.adapter = adapterNews

        val layoutManager = GridLayoutManager(this, 1)
        recycler.layoutManager = layoutManager

        viewModelNews.getAllNews()
        viewModelNews.listMutableNews.observe(this, Observer {
            it?.let { itChar -> article.addAll(itChar) }
            adapterNews.notifyDataSetChanged()
        })
        viewModelNews.messageError.observe(this, Observer {
            if (it != null){
                Toast.makeText(this, it,  Toast.LENGTH_LONG).show()
            }
        })


    }

}

