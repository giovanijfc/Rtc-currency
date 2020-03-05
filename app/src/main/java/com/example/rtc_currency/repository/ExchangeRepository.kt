package com.example.rtc_currency.repository

import com.example.rtc_currency.services.ExchangeService
import retrofit2.Retrofit

class ExchangeRepository(retrofit: Retrofit) {

    private val service = retrofit.create(ExchangeService::class.java)

    suspend fun getExchanges() = service.getExchanges()

}