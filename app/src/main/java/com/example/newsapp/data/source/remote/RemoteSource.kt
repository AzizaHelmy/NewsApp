package com.example.newsapp.data.source.remote

import com.example.newsapp.data.entites.NewsModel
import retrofit2.Response

interface RemoteSource {
    suspend fun getNews():Response<NewsModel>
}