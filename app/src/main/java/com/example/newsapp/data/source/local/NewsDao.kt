package com.example.newsapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.data.entites.NewsModel

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNew(new: NewsModel)

    @Query("select * from News")
    fun getAllNews(): LiveData<List<NewsModel>>

    @Insert
    fun insertFav(new: NewsModel)

    @Delete
    fun removeFav(new: NewsModel)

//    @Query("SELECT * from news where isFav Like 1")
//    fun getFavs()
}