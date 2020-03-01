package com.example.rtc_currency.services

import android.util.Log
import com.example.rtc_currency.database.models.Exchange
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class StartSync(retrofit: Retrofit) {

    init {
        Log.i("SYNC", "START")

        val exchangeService = retrofit.create(ExchangeService::class.java)

        exchangeService.getExchanges().enqueue(object: Callback<Collection<Exchange>> {
            override fun onResponse(call: Call<Collection<Exchange>>, res: Response<Collection<Exchange>>) {
                if (res.code() === 200) {
                    Log.i("RESPONSE", res.body().toString())
                }
            }

            override fun onFailure(call: Call<Collection<Exchange>>, t: Throwable) {
                Log.i("TROWABLE", t.toString())
            }
        })

        Log.i("SYNC", "FINISH")
    }
}

