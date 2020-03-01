package com.example.rtc_currency.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rtc_currency.R
import com.example.rtc_currency.ui.view_model.SplashViewModel
import java.util.ArrayList

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        splashViewModel.exchanges.observe(this, Observer {
            exchangesUpdated ->

            val homeIntent = Intent(this, HomeActivity::class.java)
            homeIntent.putParcelableArrayListExtra("EXCHANGES", ArrayList(exchangesUpdated));
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(homeIntent)
        })
    }
}
