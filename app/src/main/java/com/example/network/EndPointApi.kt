package com.example.network

import com.example.model.NewsResponse
import retrofit2.http.GET

interface EndPointApi {

    @GET("news")
    suspend fun getAllNews(): NewsResponse
}