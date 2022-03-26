package com.example.newsapp.data.source.remote

import com.example.newsapp.utils.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitFactory {

    fun getInstance(): RetrofitService {
        //TODO adding interceptor
        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
    }
//    private val getInstance: Retrofit by lazy{
//        Retrofit.Builder().baseUrl(Constant.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//    val retrofitService:RetrofitService by lazy {
//        getInstance.create(RetrofitService::class.java)
//    }


}