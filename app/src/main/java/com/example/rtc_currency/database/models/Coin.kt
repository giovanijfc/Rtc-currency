package com.example.rtc_currency.database.models

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

class Coin {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    @SerializedName("base")
    var base: String? = null
    @SerializedName("target")
    var target: String? = null
    @SerializedName("last")
    var lastPrice: String? = null
    @SerializedName("volume")
    var volume: String? = null
    @SerializedName("trust_score")
    var trustForExchange: String? = null
    @SerializedName("coin_id")
    var coinId: String? = null
    @SerializedName("target_coin_id")
    var targetCoinId: String? = null

    override fun toString(): String {
        return "Coin(id=$id, base=$base, target=$target, lastPrice=$lastPrice, volume=$volume, trustForExchange=$trustForExchange, coindId=$coinId, targetId=$targetCoinId)"
    }
}