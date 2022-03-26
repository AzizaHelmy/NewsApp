package com.example.newsapp.features.auth

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.newsapp.data.entites.User
import com.example.newsapp.data.repo.user.UserRepository

class AuthViewModel(private val repository: UserRepository): ViewModel() {

    fun getUserByEmail(email:String): LiveData<List<User>>? {
      return repository.getUserByEmail(email)
    }

    fun insertUser(user: User){
        repository.insertUser(user)
    }

}