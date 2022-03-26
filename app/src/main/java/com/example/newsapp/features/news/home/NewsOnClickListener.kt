package com.example.newsapp.features.news.home

import com.example.newsapp.data.entites.Article
import com.example.newsapp.data.entites.NewsModel

interface NewsOnClickListener {
    fun onFavClicked(favNew: Article)
    fun onItemClicked(item: Article)
}