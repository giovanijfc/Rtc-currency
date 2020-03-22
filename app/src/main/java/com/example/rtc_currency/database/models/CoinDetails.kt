package com.example.rtc_currency.database.models

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

class CoinDetails {

    @SerializedName("id")
    var id: String = ""
    @SerializedName("name")
    var name: String? = null
    @SerializedName("image")
    var image: ImageCoin? = null

    override fun toString(): String {
        return "CoinDetails(id='$id', name=$name, image=$image)"
    }
}