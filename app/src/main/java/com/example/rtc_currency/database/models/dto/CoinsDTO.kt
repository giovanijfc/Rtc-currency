package com.example.rtc_currency.database.models.dto

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

class CoinsDTO {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("symbol")
    var symbol: String? = null
    @SerializedName("name")
    var name: String? = null

    override fun toString(): String {
        return "CoinsDTO(id=$id, symbol=$symbol, name=$name)"
    }
}