package com.example.newsapp.data

import com.example.newsapp.data.entites.CashedNews

sealed class HomeState{

    object Loading : HomeState()
    data class Error(val errorMessage: String) : HomeState()
    data class Success(val cashedViewsList: List<CashedNews>) : HomeState()
}
