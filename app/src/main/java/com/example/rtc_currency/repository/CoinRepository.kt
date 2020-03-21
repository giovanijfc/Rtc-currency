package com.example.rtc_currency.repository

import com.example.rtc_currency.services.CoinService
import com.example.rtc_currency.services.ExchangeService
import retrofit2.Retrofit

class CoinRepository(retrofit: Retrofit) {

    private val service = retrofit.create(CoinService::class.java)

    suspend fun getAllExchangeCoins(exchangeId: String?) = service.getAllCoinsByExchangeId(exchangeId)

}