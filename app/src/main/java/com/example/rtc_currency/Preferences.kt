package com.example.rtc_currency

import android.content.Context
import android.content.SharedPreferences

class Preferences(private val context: Context) {

    private val PREFERENCE_NAME = "MY_PREFER_CUSTOM_HEHE"

    private val FIRST_INITIALIZATION = "FIRST_INITIALIZATION"

    fun isFirstInitialization() : Boolean {
        val pref = context.getSharedPreferences(PREFERENCE_NAME, 0)
        return pref.getBoolean(FIRST_INITIALIZATION, true)
    }

    fun setIsFirstInitialization(value: Boolean) {
        val pref = context.getSharedPreferences(PREFERENCE_NAME, 0)
        pref.edit().putBoolean(FIRST_INITIALIZATION, value)
        pref.edit().commit()
    }
}