package com.example.newsapp.data.entites

import androidx.room.Entity
import java.io.Serializable
//@Entity (tableName = "article")
data class Article(
    val author: String? = null,
    val content: String?=null,
    val description: String?=null,
    val publishedAt: String?=null,
    val source: Source?=null,
    val title: String?=null,
    val url: String,
    val urlToImage: String?=null
):Serializable{
    companion object{
        fun Article.toCashedList() =
                CashedNews(
                    author = author,
                    content = content,
                    description = description,
                    publishedAt = publishedAt,
                    source = source,
                    title = title,
                    url = url,
                    urlToImage = urlToImage
                )
            }


}