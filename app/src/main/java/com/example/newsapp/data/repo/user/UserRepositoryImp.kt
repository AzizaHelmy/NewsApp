package com.example.newsapp.data.repo.user

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.newsapp.data.entites.User
import com.example.newsapp.data.source.local.LocalSource
import com.example.newsapp.data.source.local.NewsDatabase
import com.example.newsapp.data.source.local.UserDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepositoryImp(var localSource: LocalSource) : UserRepository {// local

    override fun getUserByEmail(email: String): LiveData<List<User>>? {
    return localSource.getUserByEmail(email)  //database?.getUserByEmail(email)
    }

    override fun insertUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch  { localSource.insertUser(user) }
    }

}
