package com.example.newsapp.data.entites

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

//@Parcelize
data class NewsModel(
    val articles: List<Article>?=null,
    val status: String?=null,
    val totalResults: Int
):Serializable{
    companion object{
        fun toCashedNewsList() = emptyList<Article>()
    }
}