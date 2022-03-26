package com.example.newsapp.features.news.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.data.HomeState
import com.example.newsapp.data.entites.CashedNews
import com.example.newsapp.data.repo.news.NewsRepositoryImp
import com.example.newsapp.data.source.local.LocalSourceImp
import com.example.newsapp.data.source.remote.RemoteSourceImp
import com.example.newsapp.databinding.FragmentHomeBinding
import com.example.newsapp.features.news.NewsViewModel
import com.example.newsapp.features.news.NewsViewModelFactory

class HomeFragment : Fragment(), NewsOnClickListener{

    private lateinit var binding: FragmentHomeBinding
    private lateinit var newsAdapter: NewsAdapter
    private var cashedViews: List<CashedNews> = listOf()

    private val viewModel: NewsViewModel by viewModels<NewsViewModel>() {
        val remote: RemoteSourceImp = RemoteSourceImp()
        val local: LocalSourceImp = LocalSourceImp(requireContext())
        NewsViewModelFactory(NewsRepositoryImp(remote, local))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.insert()
        viewModel.getNews().observe(viewLifecycleOwner, { cashedData->
                cashedViews=cashedData
                setUpRecyclerView()
            Log.e("TAG","news $cashedViews")
        })
//        viewModel.liveData.observe(viewLifecycleOwner){ cashedData->
//            cashedData?.let {
//                cashedViews=it
//                setUpRecyclerView()
//            }
//
//            Log.e("TAG","news $cashedViews")
//        }
        viewModel.stateLiveData.observe(viewLifecycleOwner) { state ->
            //renderState(state)
        }
        binding.searchView.setOnClickListener {

        }
    }

    override fun onResume() {
        super.onResume()
        //binding.shimmerFrameLayout.startShimmer()
    }

    override fun onPause() {
        super.onPause()
       // binding.shimmerFrameLayout.stopShimmer()
    }
    private fun setUpRecyclerView() {
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.rvNews.layoutManager = layoutManager
        newsAdapter = NewsAdapter(cashedViews, requireContext(),this)
        binding.rvNews.adapter = newsAdapter

        binding.rvNews.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    // Log.d("ManoO", "Bottom");
//                    val totalPages: Int = meta.getTotalPages()
//                    if (currentPage != totalPages) {
//                        getAllPosts(chapterId, ++currentPage)
//                    }
                }
            }
        })
    }

    override fun onFavClicked(favNew: CashedNews) {
        //cheak and change img
      // viewModel.insertFav(favNew)

      //  binding.//how to reach to adapter????

    }

    override fun onItemClicked(item: CashedNews) {
        //save args
        val action = HomeFragmentDirections.actionHomeFragmentToDetailsFragment(item)
        findNavController().navigate(action)
        //Navigation.findNavController(requireView()).navigate(R.id.action_homeFragment_to_detailsFragment)
    }

    private fun renderState(state: HomeState) {
        when (state) {
            is HomeState.Error -> showError(state.errorMessage)
            HomeState.Loading -> showLoading()
            is HomeState.Success -> showSuccess(state)
        }
    }

    private fun showError(errorMessage: String) {
       //handel error state
        //binding.shimmerFrameLayout.visibility=View.GONE
    }

    private fun showLoading() {
        binding.loadingPb.visibility=View.VISIBLE
      // binding.shimmerFrameLayout.visibility=View.GONE
        binding.rvNews.visibility=View.GONE
    }

    private fun showSuccess(state: HomeState.Success) {
        binding!!.loadingPb.visibility=View.GONE
       // binding!!.shimmerFrameLayout.visibility=View.GONE
        setUpRecyclerView()
    }

    override fun onDestroy() {
        super.onDestroy()
       // binding=null//avoid memory leaks
    }

}