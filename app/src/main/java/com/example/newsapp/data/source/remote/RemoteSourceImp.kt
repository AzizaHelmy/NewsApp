package com.example.newsapp.data.source.remote

import com.example.newsapp.data.entites.NewsModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class RemoteSourceImp:RemoteSource {

    override suspend fun getNews(): Response<NewsModel> {
        val newsCall = RetrofitFactory.getInstance()
        val response = newsCall.getNews()
        return response
    }
}