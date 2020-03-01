package com.example.rtc_currency.repository

import android.util.Log
import com.example.rtc_currency.services.ExchangeService
import kotlinx.coroutines.async
import retrofit2.Retrofit
import java.util.*

class ExchangeRepository(retrofit: Retrofit) {

    private val service = retrofit.create(ExchangeService::class.java)

    suspend fun getExchanges() = service.getExchanges()

}