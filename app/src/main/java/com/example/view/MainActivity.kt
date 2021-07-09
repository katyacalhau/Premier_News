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
    private lateinit var adapterNews: NewsAdapter
    private lateinit var refreshLayout: SwipeRefreshLayout
    private lateinit var recycler: RecyclerView
    private lateinit var viewModelNews: ViewModelNews

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelNews = ViewModelProviders.of(this).get(ViewModelNews::class.java)
        initViews()
        callGetAllNews()
        initRecyclerView()

        refreshLayout.setOnRefreshListener {
            callGetAllNews()
            initRecyclerView()
        }

    }

    private fun callGetAllNews() {
        viewModelNews.getAllNews()
        viewModelNews.listMutableNews.observe(this, Observer {
            it?.let { itChar -> article.addAll(itChar) }
            adapterNews.notifyDataSetChanged()
            refreshLayout.isRefreshing = false
        })

        viewModelNews.messageError.observe(this, Observer {
            if (it != null) {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initRecyclerView() {
        adapterNews = NewsAdapter(article, this)
        recycler.adapter = adapterNews

        val layoutManager = GridLayoutManager(this, 1)
        recycler.layoutManager = layoutManager
    }

    private fun initViews() {
        recycler = findViewById(R.id.recycler_home)
        refreshLayout = findViewById(R.id.refresh)
    }
}