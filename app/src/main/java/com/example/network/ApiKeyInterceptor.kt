package com.example.network


import com.example.repository.RepositoryNews
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class ApiKeyInterceptor {
    @Throws(IOException::class)
    fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val originalUrl: HttpUrl = originalRequest.url
        val newURL: HttpUrl = originalUrl.newBuilder()
            .addQueryParameter("api_key", RepositoryNews.key_api).build()
        val requestBuilder: Request.Builder = originalRequest.newBuilder().url(newURL)
        val request: Request = requestBuilder.build()
        return chain.proceed(request)
    }
}