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

   /* companion object {
        private var INSTANCE: UserRepositoryImp? = null
        private var database: UserDao? = null
        fun getUserRepository(app: Application): UserRepositoryImp {
            if (INSTANCE == null) {
                database = NewsDatabase.getInstance(app).userDao()
            }
            return INSTANCE as UserRepositoryImp
        }
    }*/

    override fun getUserByEmail(email: String): LiveData<List<User>>? {
    return localSource.getUserByEmail(email)  //database?.getUserByEmail(email)
    }

    override fun insertUser(user: User) {
        CoroutineScope(Dispatchers.IO).launch  { localSource.insertUser(user) }
    }
}
