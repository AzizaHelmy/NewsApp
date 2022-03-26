package com.example.newsapp.data.repo.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.data.HomeState
import com.example.newsapp.data.entites.Article.Companion.toCashedList
import com.example.newsapp.data.entites.CashedNews
import com.example.newsapp.data.source.local.ConcretLocalSource
import com.example.newsapp.data.source.remote.RemoteSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsRepositoryImp(
    private val remoteSource: RemoteSource,
    private val localSource: ConcretLocalSource
) :
    NewsRepository {
    override suspend fun InsertNews() {
           val newsCall = remoteSource.getNews()
         if (newsCall.isSuccessful){
             newsCall.body()?.articles?.forEach {
                 it.toCashedList()?.let {
                         it1 -> localSource.insertNew(it1) }
             }
        }
    }

    override fun removeFav(fav: CashedNews) {
        localSource.removeFav(fav)
    }

    override fun insertFav(fav: CashedNews) {
        CoroutineScope(Dispatchers.IO).launch {
            localSource.insertFav(fav)
        }

    }

    override fun getFav(): List<CashedNews> {
        TODO("Not yet implemented")
    }

    override  fun getNewsFromDB(): LiveData<List<CashedNews>> {
       return localSource.getAllNews()
    }


}