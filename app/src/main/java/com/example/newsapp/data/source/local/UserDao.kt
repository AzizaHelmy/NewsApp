package com.example.newsapp.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsapp.data.entites.User

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE email LIKE :email")
    fun getUserByEmail(email: String): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: User)
}