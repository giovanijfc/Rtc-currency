package com.example.rtc_currency.ui.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.rtc_currency.database.AppDatabase
import com.example.rtc_currency.database.models.Exchange
import com.example.rtc_currency.repository.CoinRepository
import com.example.rtc_currency.repository.ExchangeRepository
import com.example.rtc_currency.services.CoinService
import com.example.rtc_currency.services.config.RetrofitInitializer
import com.example.rtc_currency.utils.Connection
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit

class ListCoinsViewModel(application: Application) : AndroidViewModel(application) {

    private val retrofit: Retrofit = RetrofitInitializer().retrofit
    private var db: AppDatabase? = null
    private val exchangeRepo = ExchangeRepository(retrofit)
    private val coinRepo = CoinRepository(retrofit)

    var exchange = MutableLiveData<Exchange?>()
    val coins: LiveData<List<String>?> = liveData(Dispatchers.IO) {
        val coins  = coinRepo.getAllCoinsIds().toList()

        Log.d("COINS_DTO", coins.toString())
    }

    init {
        db = AppDatabase.getDB(application)
    }

    fun setExchange(exchangeUpdated: Exchange?) {
        exchange.postValue(exchangeUpdated)
    }
}