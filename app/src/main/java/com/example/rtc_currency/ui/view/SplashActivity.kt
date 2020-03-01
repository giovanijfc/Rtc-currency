package com.example.rtc_currency.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.lifecycle.ViewModelProviders
import com.example.rtc_currency.R
import com.example.rtc_currency.services.StartSync
import com.example.rtc_currency.services.config.RetrofitInitializer
import com.example.rtc_currency.ui.view_model.HomeViewModel
import com.example.rtc_currency.ui.view_model.SplashViewModel
import retrofit2.Retrofit

class SplashActivity : AppCompatActivity() {

    private val retrofit: Retrofit = RetrofitInitializer().retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val splashViewModel = ViewModelProviders.of(this).get(SplashViewModel::class.java)

        StartSync(retrofit)

        Thread {
            val homeIntent = Intent(this, HomeActivity::class.java)
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            Thread.sleep(500)
            startActivity(homeIntent)
        }.start()
    }
}
