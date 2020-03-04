package com.example.rtc_currency.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.rtc_currency.database.models.Exchange

@Dao
interface ExchangeDAO {

    @Query("SELECT * FROM Exchange")
    fun getAll(): List<Exchange>

    @Insert
    fun insertAll(exchanges: List<Exchange>)
}