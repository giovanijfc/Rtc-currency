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
import com.example.rtc_currency.utils.Connection
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit

class SplashViewModel(application: Application) : AndroidViewModel(application) {

    private val retrofit: Retrofit = RetrofitInitializer().retrofit
    private val exchangeRepo = ExchangeRepository(retrofit)
    var db: AppDatabase? = null

    init {
        db = AppDatabase.getDB(application)
    }

    val exchanges: LiveData<List<Exchange>?> = liveData(Dispatchers.IO) {
        val isConnectionAvailable = Connection.isInternetAvailable(application.applicationContext)
        var exchanges: List<Exchange>?
        var exchangesFromDB = db!!.exchangeDAO().getAll();

        exchanges = when {
            isConnectionAvailable -> exchangeRepo.getExchanges().toList()
            else -> exchangesFromDB
        }

        exchanges.forEachIndexed { index, exchange ->
            if (exchangesFromDB.isNotEmpty()) {
                exchange.isFavorite = exchangesFromDB[index].isFavorite
            }
        }

        if (exchanges.isNotEmpty()) {
            db?.exchangeDAO()?.deteleAll()
            db?.exchangeDAO()?.insertAll(exchanges)
        }

        emit(exchanges)
    }
}