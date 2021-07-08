package com.example.network

import com.example.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EndPointApi {

    @GET("top-headlines")
    suspend fun getAllNews(
        @Query("country") country: String
    ): NewsResponse
}