package com.example.newsapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.data.entites.CashedNews

interface ConcretLocalSource {
   suspend fun insertNew(aNew: CashedNews)
     fun getAllNews(): LiveData<List<CashedNews>>
    fun insertFav(aNew: CashedNews)
    fun removeFav(aNew: CashedNews)
    fun getFav(): LiveData<List<CashedNews>>
}