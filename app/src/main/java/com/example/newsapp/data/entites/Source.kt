package com.example.newsapp.data.entites

import androidx.room.Embedded
import java.io.Serializable


data class Source(
//    @Embedded
    val id: Any,
    val name: String
):Serializable