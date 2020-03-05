package com.example.rtc_currency.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rtc_currency.R
import com.example.rtc_currency.ui.view_model.SplashViewModel
import com.example.rtc_currency.utils.Dialog
import java.util.*
import kotlin.system.exitProcess

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        splashViewModel.exchanges.observe(this, Observer {
                exchangesUpdated ->

            if (exchangesUpdated!!.isEmpty()) {
                runOnUiThread {
                    val closeApp = {
                        exitProcess(-1)
                    }
                    Dialog.showOk(this@SplashActivity,
                        getString(R.string.title_internet_connection),
                        getString(R.string.description_internet_connection), closeApp)
                }
            } else {
                val homeIntent = Intent(this, HomeActivity::class.java)
                homeIntent.putParcelableArrayListExtra("EXCHANGES", exchangesUpdated?.let { ArrayList(it) })
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(homeIntent)
            }
        })
    }
}
