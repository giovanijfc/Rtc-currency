package com.example.rtc_currency.database.models

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

class ExchangeCoins {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    @SerializedName("name")
    var name: String? = null
    @SerializedName("tickers")
    var coins: List<Coin>? = null

    override fun toString(): String {
        return "ExchangeCoins(id=$id, name=$name, coins=$coins)"
    }
}