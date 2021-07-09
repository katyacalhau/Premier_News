package com.example.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class ActivityDetail : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle: Bundle? = intent.extras
        webView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        bundle?.getString("url")?.let { webView.loadUrl(it) }
    }



}