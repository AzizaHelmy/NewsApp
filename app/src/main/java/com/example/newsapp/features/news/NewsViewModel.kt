package com.example.newsapp.features.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.data.HomeState
import com.example.newsapp.data.entites.NewsModel
import com.example.newsapp.data.repo.news.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    private var mutableLiveData = MutableLiveData<NewsModel>()
    var liveData: LiveData<NewsModel> = mutableLiveData

    private val _stateLiveData: MutableLiveData<HomeState> = MutableLiveData(HomeState.Loading)
    val stateLiveData: LiveData<HomeState> = _stateLiveData

    fun getNews() {
        viewModelScope.launch {
          val response=  newsRepository.getNews()
//            if(response.isSuccessful){
//             mutableLiveData.value=response.body()
//            }
        }
    }

    fun removeFav(favNew:NewsModel){
        newsRepository.removeFav(favNew)
    }

    fun insertFav(favNew: NewsModel){
        newsRepository.insertFav(favNew)
    }
}