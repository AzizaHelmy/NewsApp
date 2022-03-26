package com.example.newsapp.features.favorite.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.data.entites.NewsModel
import com.example.newsapp.databinding.FavoriteCustomRowBinding

class FavoriteAdapter(var newsList: List<NewsModel>, var context: Context): RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(
            FavoriteCustomRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val model = newsList[position]
//        Glide.with(context!!).load(model.articles[0].urlToImage).into(holder.binding.newsImg)
//        holder.binding.title.text=model.articles[0].title
//        holder.binding.time.text=model.articles[0].publishedAt
//        holder.binding.fav.setImageResource(R.drawable.ic_favorite)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class FavoriteViewHolder(val binding: FavoriteCustomRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}
