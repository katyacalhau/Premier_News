package com.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.model.Article
import com.example.model.NewsResponse
import com.example.model.Source
import com.example.repository.RepositoryNews
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.newCoroutineContext

class ViewModelNews : ViewModel() {

    val listMutableNews = MutableLiveData<List<Article>>()
    val messageError = MutableLiveData<String>()
    private val repository = RepositoryNews()

    fun getAllNews() = CoroutineScope(Dispatchers.IO).launch {
        try {
            repository.getAllNewsService().let { newsResponse ->
                listMutableNews.postValue(newsResponse.articles)
            }
        } catch (error : Throwable){
            messageError.postValue("Problema de conexão $error")
        }

    }
}
