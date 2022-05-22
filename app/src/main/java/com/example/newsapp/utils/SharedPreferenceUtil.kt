package com.example.newsapp.utils

import android.content.Context
import android.preference.PreferenceManager
import com.example.newsapp.R

class SharedPreferenceUtil {


    companion object {

        fun isLogged(context: Context): Boolean {
            val sp = PreferenceManager.getDefaultSharedPreferences(context)
            return sp.getBoolean(context.getString(R.string.preference_loggin), false)
        }

        fun setUserLoggedIn(context: Context) {
            val sp = PreferenceManager.getDefaultSharedPreferences(context).edit()
            sp.putBoolean(context.getString(R.string.preference_loggin), true)
        }

        fun setUserLoggedOut(context: Context) {
            val sp = PreferenceManager.getDefaultSharedPreferences(context).edit()
            sp.putBoolean(context.getString(R.string.preference_loggin), false)
        }
    }
}