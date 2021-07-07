package com.example.repository

import com.example.model.NewsResponse
import com.example.network.EndPointApi
import com.example.network.RetrofitInit


class RepositoryNews {

    private var url = "https://newsapi.org/"
    private val key_api = "eea5437642914a46a9f3a6b0752ee230"
    private var service = EndPointApi::class
    private var serviceNews = RetrofitInit(url).create(service)

    suspend fun getAllNewsService() : NewsResponse = serviceNews.getAllNews()


}