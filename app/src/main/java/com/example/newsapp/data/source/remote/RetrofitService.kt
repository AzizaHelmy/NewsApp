package com.example.newsapp.data.source.remote


import com.example.newsapp.data.entites.NewsModel
import com.example.newsapp.utils.Constant
import retrofit2.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitService {
    //top-headlines?country=us&apiKey=
     //@Headers("X-Api-Key: $NEWS_API_KEY")
    @GET("top-headlines?country=us")
    @Headers("X-Api-Key: ${Constant.API_KEY2}")
    suspend fun getNews(): Response<NewsModel>
}