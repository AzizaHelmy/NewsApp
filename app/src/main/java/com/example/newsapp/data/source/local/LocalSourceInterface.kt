package com.example.newsapp.data.source.local

import com.example.newsapp.data.entites.User

interface LocalSourceInterface {

    fun getUserByEmail(email:String)
    fun insertUser(user: User)

}