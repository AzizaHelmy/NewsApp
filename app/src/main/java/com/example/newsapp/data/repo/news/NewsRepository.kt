package com.example.newsapp.data.repo.news

import com.example.newsapp.data.HomeState
import com.example.newsapp.data.entites.NewsModel
import retrofit2.Response

interface NewsRepository {
suspend fun getNews():HomeState
fun removeFav(fav:NewsModel)
fun insertFav(fav:NewsModel)
}