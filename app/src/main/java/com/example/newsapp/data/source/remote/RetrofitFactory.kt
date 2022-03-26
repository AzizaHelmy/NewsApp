package com.example.newsapp.data.source.remote

import com.example.newsapp.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    fun getInstance(): RetrofitService {
        //TODO adding interceptor
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
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