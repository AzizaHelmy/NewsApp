package com.example.newsapp.features.settings

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.newsapp.NewsActivity
import com.example.newsapp.R
import com.example.newsapp.features.auth.AuthActivity
import com.example.newsapp.utils.SharedPreferenceUtil

class SettingsFragment : Fragment() {
   lateinit var loggoutBtn : Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      val view =inflater.inflate(R.layout.fragment_settings, container, false)

        loggoutBtn=view.findViewById(R.id.setting_button_logOut)
        loggoutBtn.setOnClickListener {  val intent = Intent(context, AuthActivity::class.java)
           intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent) }



        return view   }

}