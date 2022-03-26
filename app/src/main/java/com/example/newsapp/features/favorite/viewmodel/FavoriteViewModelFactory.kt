package com.example.newsapp.features.favorite.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.data.repo.news.NewsRepository

class FavoriteViewModelFactory (private val newsRepo: NewsRepository):  ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FavoriteViewModel(newsRepo) as T
    }

}