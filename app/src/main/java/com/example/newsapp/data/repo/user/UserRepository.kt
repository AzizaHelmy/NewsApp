package com.example.newsapp.data.repo.user

import androidx.lifecycle.LiveData
import com.example.newsapp.data.entites.User

interface UserRepository {
fun getUserByEmail(email:String): LiveData<List<User>>?
    fun insertUser(user:User)
}