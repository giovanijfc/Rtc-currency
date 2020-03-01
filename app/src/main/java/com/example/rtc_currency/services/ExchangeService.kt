package com.example.rtc_currency.services

import com.example.rtc_currency.database.models.Exchange
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ExchangeService {

    @GET("exchanges")
    suspend fun getExchanges(): Collection<Exchange>

}