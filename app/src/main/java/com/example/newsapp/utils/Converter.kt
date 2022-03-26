package com.example.newsapp.utils

import androidx.room.TypeConverter
import com.example.newsapp.data.entites.Article
import com.example.newsapp.data.entites.Source
import com.google.gson.Gson

class Converter {
    @TypeConverter
    fun listArticleToJson(value: List<Article>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToArticleList(value: String) = Gson().fromJson(value, Array<Article>::class.java)?.toList()

    @TypeConverter
    fun objectSourceToJson(value: Source) = Gson().toJson(value)

    @TypeConverter
    fun jsonToSource(value: String?) = Gson().fromJson(value, Source::class.java)

}