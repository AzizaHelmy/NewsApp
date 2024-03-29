package com.example.newsapp.data.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Users")
data class User(
    val name: String,
    val password: String,
    @PrimaryKey
    val email: String,
    val PhoneNumber: String
    )
