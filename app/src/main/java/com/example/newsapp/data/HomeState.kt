package com.example.newsapp.data

import com.example.newsapp.data.entites.Article
import com.example.newsapp.data.entites.NewsModel

sealed class HomeState{

    object Loading : HomeState()
    data class Error(val errorMessage: String) : HomeState()
    data class Success(val jobsList: List<Article>) : HomeState()
}
