package com.example.newsapp.features.news

import androidx.lifecycle.*
import com.example.newsapp.data.HomeState
import com.example.newsapp.data.entites.CashedNews
import com.example.newsapp.data.repo.news.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(private val newsRepository: NewsRepository) : ViewModel() {
    private var mutableLiveData = MutableLiveData<List<CashedNews>>()
    var liveData: LiveData<List<CashedNews>> = mutableLiveData

    private val _stateLiveData: MutableLiveData<HomeState> = MutableLiveData(HomeState.Loading)
    val stateLiveData: LiveData<HomeState> = _stateLiveData

    fun getNews(): LiveData<List<CashedNews>>   {
        return newsRepository.getNewsFromDB()
//           val liveData = MediatorLiveData<CashedNews>()
//           liveData.addSource(newsRepository.getNewsFromDB(), Observer {
//               if (it != null) {
//                   // put your logic here
//                   mutableLiveData.value = it
//               }
//           })
    }


    fun insert(){
        viewModelScope.launch(Dispatchers.IO) {
            newsRepository.InsertNews()
        }
    }

    fun removeFav(favNew: CashedNews){
        newsRepository.removeFav(favNew)
    }

    fun insertFav(favNew: CashedNews){
        newsRepository.insertFav(favNew)
    }
    
    fun getFav() {


    }
}