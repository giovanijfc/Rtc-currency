package com.example.rtc_currency.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.rtc_currency.R
import com.example.rtc_currency.ui.view_model.HomeViewModel

class HomeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        homeViewModel.checkFirstInitializationApp()
    }
}
