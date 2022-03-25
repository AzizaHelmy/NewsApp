package com.example.newsapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [NewsModel::class, User::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class NewsDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao
    abstract fun userDao(): UserDao

    companion object {
        fun getInstance(context: Context): NewsDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                NewsDatabase::class.java,
                "weather"
            ).build()
        }
    }

}