package com.example.newsapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.data.entites.CashedNews

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNew(aNew: CashedNews)

    @Query("select * from News")
    fun getAllNews(): LiveData<List<CashedNews>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFav(aNew: CashedNews)

    @Delete
    fun removeFav(aNew: CashedNews)

    @Query("SELECT * from news where isFav Like 1")
    fun getFavs():LiveData<List<CashedNews>>
}