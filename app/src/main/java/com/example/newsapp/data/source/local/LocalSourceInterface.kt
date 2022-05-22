package com.example.newsapp.data.source.local

import androidx.lifecycle.LiveData
import com.example.newsapp.data.entites.User

interface LocalSourceInterface {

    fun getUserByEmail(email:String): LiveData<List<User>>?
    fun insertUser(user: User)

}