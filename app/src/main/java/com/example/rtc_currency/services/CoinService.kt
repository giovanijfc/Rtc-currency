package com.example.rtc_currency.services

import com.example.rtc_currency.database.models.dto.CoinsDTO
import retrofit2.http.GET

interface CoinService {

    @GET("coins/list")
    suspend fun getAllCoinsIds(): Collection<CoinsDTO>
}