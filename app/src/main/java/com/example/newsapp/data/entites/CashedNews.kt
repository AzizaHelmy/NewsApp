package com.example.newsapp.data.entites

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "News")
data class CashedNews(
                      val author: String?=null,
                      val content: String?=null,
                      val description: String?=null,
                      val publishedAt: String?=null,
//                      @Embedded
                 val source: Source?=null,
                      val title: String?=null,
                      @PrimaryKey
                 val url: String,
                      val urlToImage: String?=null,
                      val isFav: Boolean = false): Serializable
