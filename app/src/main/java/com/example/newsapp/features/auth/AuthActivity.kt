package com.example.newsapp.features.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.impl.utils.PreferenceUtils
import com.example.newsapp.NewsActivity
import com.example.newsapp.R
import com.example.newsapp.utils.SharedPreferenceUtil

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(SharedPreferenceUtil.isLogged(context = applicationContext))
        {
            var intent = Intent(application, NewsActivity::class.java)
            startActivity(intent)
        }
        setContentView(R.layout.activity_auth)
    }
}