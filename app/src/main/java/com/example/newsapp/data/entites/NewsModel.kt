package com.example.newsapp.data.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "News")
data class NewsModel(
    val articles: List<Article>,
    @PrimaryKey
    val status: String,
    val totalResults: Int
)