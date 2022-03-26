package com.example.newsapp.features.news.home

import com.example.newsapp.data.entites.CashedNews

interface NewsOnClickListener {
    fun onFavClicked(favNew: CashedNews)
    fun onItemClicked(item: CashedNews)
}