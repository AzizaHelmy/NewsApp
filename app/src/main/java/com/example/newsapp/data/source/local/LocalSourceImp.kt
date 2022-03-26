package com.example.newsapp.data.source.local

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.newsapp.data.entites.NewsModel

class LocalSourceImp(context: Context):ConcretLocalSource {

    val database: NewsDatabase = NewsDatabase.getInstance(context)
    var newsDao: NewsDao  = database.newsDao()

    override fun insertNew(new: NewsModel) {
       newsDao.insertNew(new)
    }

    override fun getAllNews(): LiveData<List<NewsModel>> {
        return newsDao.getAllNews()
    }

    override fun insertFav(new: NewsModel) {
        return newsDao.insertFav(new)
    }

    override fun removeFav(new: NewsModel) {
        newsDao.removeFav(new)
    }

}