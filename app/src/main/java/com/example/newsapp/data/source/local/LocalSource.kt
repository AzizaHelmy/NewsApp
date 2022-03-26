package com.example.newsapp.data.source.local

import androidx.lifecycle.LiveData
import com.example.newsapp.data.entites.User

class LocalSource(var dao: UserDao) : LocalSourceInterface {

    override fun getUserByEmail(email: String): LiveData<List<User>>? {
   return dao.getUserByEmail(email)
    }

    override fun insertUser(user: User) {
       dao.insertUser(user)
    }
}