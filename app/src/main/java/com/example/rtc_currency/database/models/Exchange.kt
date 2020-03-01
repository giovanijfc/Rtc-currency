package com.example.rtc_currency.database.models

import com.google.gson.annotations.SerializedName

class Exchange {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("name")
    var name: String? = null

    override fun toString(): String {
        return "Exchange(id=$id, name=$name)"
    }
}