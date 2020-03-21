package com.example.rtc_currency.ui.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.rtc_currency.R
import com.example.rtc_currency.database.models.Exchange
import com.example.rtc_currency.ui.view_model.ListCoinsViewModel

class ListCoinsActivity : AppCompatActivity() {

    var listCoinsViewModel: ListCoinsViewModel? = null
    var exchange: Exchange? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_coins)

        exchange = intent.getParcelableExtra("EXCHANGE")
        listCoinsViewModel = ViewModelProvider(this).get(ListCoinsViewModel::class.java)

        listCoinsViewModel?.setExchange(exchange)

        listCoinsViewModel?.exchangeCoins?.observe(this, Observer { exchangeCoins ->
            Log.d("COINS_DTO", exchangeCoins.toString())
        })
    }
}
