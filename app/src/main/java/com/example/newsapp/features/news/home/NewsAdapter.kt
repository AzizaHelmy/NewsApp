package com.example.newsapp.features.news.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.data.entites.CashedNews
import com.example.newsapp.databinding.NewsItemBinding

class NewsAdapter(val cashedViews: List<CashedNews>, val context: Context, var newsOnClickListener: NewsOnClickListener) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            NewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val model = cashedViews[position]

        Glide.with(context).load(model.urlToImage)
            .placeholder(R.drawable.img)
            .into(holder.binding.ivNewsImg)
        holder.binding.tvTitle.text=model.title
        holder.binding.tvTime.text=model.publishedAt
        holder.binding.ivFav.setImageResource(R.drawable.ic_favorite_border)
        holder.binding.ivFav.setOnClickListener {
            newsOnClickListener.onFavClicked(model)
            holder.binding.ivFav.setImageResource(R.drawable.ic_favorite)
        }
        holder.itemView.setOnClickListener {
           newsOnClickListener.onItemClicked(model)
        }
    }

    override fun getItemCount(): Int {
        return cashedViews.size
    }

    class NewsViewHolder(val binding: NewsItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}
