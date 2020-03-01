package com.example.rtc_currency.services

import com.example.rtc_currency.database.models.Exchange
import retrofit2.Call
import retrofit2.http.GET

interface ExchangeService {

    @GET("exchanges/list")
    fun getExchanges(): Call<Collection<Exchange>>

}