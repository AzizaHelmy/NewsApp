package com.example.newsapp.data.source.remote

interface RemoteSource {
    suspend fun getNews()//take model as a prameter
}