package com.example.rtc_currency.ui.view_model

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.rtc_currency.database.AppDatabase
import com.example.rtc_currency.database.models.Exchange
import com.example.rtc_currency.repository.ExchangeRepository
import com.example.rtc_currency.services.config.RetrofitInitializer
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit

class SplashViewModel(application: Application) : AndroidViewModel(application) {

    private val retrofit: Retrofit = RetrofitInitializer().retrofit
    private val exchangeRepo = ExchangeRepository(retrofit)
    private var db: AppDatabase? = null

    init {
        db = AppDatabase.getDB(application)
    }

    val exchanges: LiveData<Collection<Exchange>> = liveData(Dispatchers.IO) {
        val exchanges = exchangeRepo.getExchanges()
        db?.exchangeDAO()!!.insertAll(exchanges.toList());
        val exchangesToDB = db?.exchangeDAO()!!.getAll().size.toString()
        Log.i("Exchanges", exchangesToDB)
        emit(exchanges)
    }
}