package com.example.rtc_currency.services

import com.example.rtc_currency.database.models.CoinDetails
import com.example.rtc_currency.database.models.ExchangeCoins
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinService {

    @GET("exchanges/{exchangeId}/tickers")
    suspend fun getAllCoinsByExchangeId(@Path("exchangeId") exchangeId: String?): ExchangeCoins

    @GET("coins/{coinId}?localization=false&tickers=false&market_data=false&community_data=false&developer_data=false&sparkline=false")
    suspend fun getCoinDetails(@Path("coinId") coinId: String?): CoinDetails
}