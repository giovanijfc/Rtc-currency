package com.example.rtc_currency.ui.view_model

import android.app.Application
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.rtc_currency.Preferences
import com.example.rtc_currency.ui.view.StepsInfoActivity

class HomeViewModel(application: Application): AndroidViewModel(application) {

    private val context: Context = getApplication<Application>().applicationContext

    fun checkFirstInitializationApp () {
        val preferences = Preferences(context)
        val isFirstInitialization = preferences.isFirstInitialization()

        Log.i("FIRST INITIALIZATION?", isFirstInitialization.toString())
        if (isFirstInitialization) {
            val stepsInfoIntent = Intent(context, StepsInfoActivity::class.java)
            stepsInfoIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            stepsInfoIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            context.startActivity(stepsInfoIntent)
        }
    }
}