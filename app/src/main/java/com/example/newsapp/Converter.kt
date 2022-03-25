package com.example.newsapp

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converter {
    @TypeConverter
    fun listArticleToJson(value: List<Article>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToArticleList(value: String) = Gson().fromJson(value, Array<Article>::class.java)?.toList()

}