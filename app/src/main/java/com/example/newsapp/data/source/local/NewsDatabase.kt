package com.example.newsapp.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsapp.data.entites.CashedNews
import com.example.newsapp.data.entites.User
import com.example.newsapp.utils.Converter
//,Article::class
@Database(entities = [CashedNews::class, User::class], version = 6, exportSchema = false)
@TypeConverters(Converter::class)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
    abstract fun userDao(): UserDao

    companion object {
        fun getInstance(context: Context): NewsDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                NewsDatabase::class.java,
                "News.db"
            ).build()
        }
    }

}