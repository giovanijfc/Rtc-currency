package com.example.rtc_currency

import android.content.Context
import android.content.SharedPreferences.Editor


class Preferences(context: Context) {

    private val appPreferences = context.getSharedPreferences("APP_PREFERENCES", 0)

    private val FIRST_INITIALIZATION = "FIRST_INITIALIZATION"

    fun isFirstInitialization() : Boolean {
        return appPreferences.getBoolean(FIRST_INITIALIZATION, true)
    }

    fun setIsFirstInitialization(value: Boolean) {
        val edit: Editor = appPreferences.edit()
        edit.putBoolean(FIRST_INITIALIZATION, value)
        edit.apply()
    }
}