package com.example.newsapp.features.favorite.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R
import com.example.newsapp.data.entites.NewsModel
import com.example.newsapp.databinding.FragmentDetailsBinding
import com.example.newsapp.databinding.FragmentFavoritsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FavoritsFragment : Fragment() {
    private var _binding: FragmentFavoritsBinding? = null
    private val binding get() = _binding!!
    private lateinit var  recyclerView: RecyclerView
    private var newsList  = listOf<NewsModel>()
    private lateinit var favoriteAdapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoritsBinding.inflate(inflater, container, false)




        CoroutineScope(Dispatchers.IO).launch {
             //  newsList = favoriteViewModel.getCitysFromDB()
             //  favoriteAdapter.notifyDataSetChanged()
        }
//        favoriteAdapter = FavoriteAdapter(newsList, requireContext())
//        val linearLayoutManager = LinearLayoutManager(requireContext())
//        linearLayoutManager.orientation = RecyclerView.VERTICAL
//        recyclerView = binding.favRecyclerView
//
//        recyclerView.layoutManager = linearLayoutManager


        return binding.root
    }


}