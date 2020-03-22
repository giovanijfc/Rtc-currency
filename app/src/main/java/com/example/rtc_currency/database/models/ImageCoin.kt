package com.example.rtc_currency.database.models

import com.google.gson.annotations.SerializedName

class ImageCoin {

    @SerializedName("thumb")
    var thumb: String = ""
    @SerializedName("small")
    var small: String? = null
    @SerializedName("large")
    var large: String? = null

    override fun toString(): String {
        return "ImageCoin(thumb='$thumb', small=$small, large=$large)"
    }
}