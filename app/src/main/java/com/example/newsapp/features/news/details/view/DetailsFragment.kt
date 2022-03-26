package com.example.newsapp.features.news.details.view

import android.content.Intent
import android.content.Intent.getIntent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.newsapp.data.entites.NewsModel
import com.example.newsapp.databinding.FragmentDetailsBinding
import org.w3c.dom.Text


class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
  //  val args by navArgs<DetailsFragmentArgs>()

    private lateinit var favorite: ImageView
    private lateinit var newsImageView: ImageView
    private lateinit var title: TextView
    private lateinit var publishedAt: TextView
    private lateinit var auther: TextView
    private lateinit var description: TextView
    private lateinit var content: TextView
    private lateinit var link: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      //  var model = args.CurrentNew.articals[0]
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        binding.newsImageView
        binding.autherTv
        binding.contentTv
        binding.descriptionTv
     /* *//*  binding.linkTv.text = args.CurrentNew.articals[0].
        bind*//*ing.titleTv.text = args.CurrentNew.articals[0]*/

        binding.publishedTv

      //  Glide.with(context!!).load(model.articles[0].urlToImage).into(holder.binding.newsImg)

        link.setOnClickListener(){
            val str: String = link.text.toString()
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(str)
            startActivity(openURL)
        }


        return binding.root
    }


}