package com.example.rtc_currency.services

import com.example.rtc_currency.database.models.ExchangeCoins
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinService {

    @GET("exchanges/{exchangeId}/tickers")
    suspend fun getAllCoinsByExchangeId(@Path("exchangeId") exchangeId: String?): ExchangeCoins
}