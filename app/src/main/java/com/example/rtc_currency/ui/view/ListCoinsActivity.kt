package com.example.rtc_currency.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.rtc_currency.R
import com.example.rtc_currency.ui.view_model.ListCoinsViewModel

class ListCoinsActivity : AppCompatActivity() {

    var listCoinsViewModel: ListCoinsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_coins)

        listCoinsViewModel = ViewModelProvider(this).get(ListCoinsViewModel::class.java)
    }
}
