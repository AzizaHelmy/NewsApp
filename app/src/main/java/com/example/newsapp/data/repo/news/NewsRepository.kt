package com.example.newsapp.data.repo.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.data.HomeState
import com.example.newsapp.data.entites.CashedNews

interface NewsRepository {
suspend fun InsertNews()
fun removeFav(fav: CashedNews)
fun insertFav(fav:CashedNews)
fun getFav():List<CashedNews>
 fun getNewsFromDB():LiveData<List<CashedNews>>
}