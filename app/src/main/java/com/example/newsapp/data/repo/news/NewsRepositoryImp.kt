package com.example.newsapp.data.repo.news

import android.util.Log
import com.example.newsapp.data.HomeState
import com.example.newsapp.data.entites.NewsModel
import com.example.newsapp.data.source.local.ConcretLocalSource
import com.example.newsapp.data.source.remote.RemoteSource
import com.example.newsapp.data.source.remote.RetrofitFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsRepositoryImp(
    private val remoteSource: RemoteSource,
    private val localSource: ConcretLocalSource
) :
    NewsRepository {
    override suspend fun getNews(): HomeState {

           val newsCall = remoteSource.getNews()
        return if (newsCall.isSuccessful){
            HomeState.Success(newsCall.body()!!.articles)
        }else{
            HomeState.Error(newsCall.errorBody()!!.string())
        }

    }

    override fun removeFav(fav: NewsModel) {
        localSource.removeFav(fav)
    }

    override fun insertFav(fav: NewsModel) {
        CoroutineScope(Dispatchers.IO).launch {
            localSource.insertFav(fav)
        }

    }

}