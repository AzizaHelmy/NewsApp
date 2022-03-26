package com.example.newsapp.data.source.local

import androidx.lifecycle.LiveData
import com.example.newsapp.data.entites.NewsModel

interface ConcretLocalSource {
    fun insertNew(new: NewsModel)
    fun getAllNews(): LiveData<List<NewsModel>>
    fun insertFav(new: NewsModel)
    fun removeFav(new: NewsModel)
}