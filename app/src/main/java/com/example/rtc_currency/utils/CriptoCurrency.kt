package com.example.rtc_currency.utils

class CriptoCurrency {

    companion object {

        fun getNumberCaseDecimalFromCoin(coin: String?): String {
            val numberCase = when (coin) {
                "BTC" -> "8"
                "JPY" -> "2"
                "USDT" -> "2"
                "KRW" -> "2"
                "USDC" -> "2"
                "USD" -> "2"
                "BUSD" -> "2"
                else -> "2"
            }

            return numberCase
        }
    }
}