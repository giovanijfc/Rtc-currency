package com.example.rtc_currency.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rtc_currency.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Thread {
            val homeIntent = Intent(this, HomeActivity::class.java)
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            Thread.sleep(500)
            startActivity(homeIntent)
        }.start()
    }
}
