package com.example.newsapp.data.source.local

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.newsapp.data.entites.CashedNews

class LocalSourceImp(context: Context):ConcretLocalSource {

    val database: NewsDatabase = NewsDatabase.getInstance(context)
    var newsDao: NewsDao  = database.newsDao()

    override suspend fun insertNew(aNew: CashedNews) {
       newsDao.insertNew(aNew)
    }



    override fun getAllNews(): LiveData<List<CashedNews>> {
        return newsDao.getAllNews()
    }


    override fun insertFav(aNew: CashedNews) {
        newsDao.insertFav(aNew)
    }

    override fun removeFav(aNew: CashedNews) {
        newsDao.removeFav(aNew)
    }

    override fun getFav(): LiveData<List<CashedNews>> {
       return newsDao.getFavs()
    }

}