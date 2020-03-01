package com.example.rtc_currency.services.config

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val BASE_URL_COINGECKO = "https://api.coingecko.com/api/v3/"

    open val retrofit = Retrofit.Builder().baseUrl(BASE_URL_COINGECKO)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}
