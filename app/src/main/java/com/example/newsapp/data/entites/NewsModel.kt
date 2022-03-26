package com.example.newsapp.data.entites

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Entity(tableName = "News")
//@Parcelize
data class NewsModel(
    val isFav: Boolean = false,
    val articles: List<Article>,
    @PrimaryKey
    val status: String,
    val totalResults: Int
):Serializable