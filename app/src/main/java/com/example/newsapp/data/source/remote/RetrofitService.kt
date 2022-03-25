package com.example.newsapp.data.source.remote


import com.example.newsapp.utils.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitService {
//@Headers("X-Api-Key: $NEWS_API_KEY")
    @GET("top-headlines?")
    @Headers("apiKey:${Constant.API_KEY} ")

    suspend fun getNews(
        @Query("country") country: String = Constant.COUNTRY
    )//: Response<NewsModel>
}