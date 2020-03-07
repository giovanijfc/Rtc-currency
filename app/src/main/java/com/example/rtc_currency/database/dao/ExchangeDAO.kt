package com.example.rtc_currency.database.dao

import androidx.room.*
import com.example.rtc_currency.database.models.Exchange

@Dao
interface ExchangeDAO {

    @Query("SELECT * FROM Exchange")
    fun getAll(): List<Exchange>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(exchanges: List<Exchange>)

    @Query("SELECT * FROM Exchange WHERE name LIKE :name AND isFavorite =:isListFavoriteExchange")
    fun getByNameAndIsFavorite(name: String?, isListFavoriteExchange: Boolean?): List<Exchange>

    @Query("SELECT * FROM Exchange WHERE name LIKE :name")
    fun getByName(name: String?): List<Exchange>

    @Query("DELETE FROM exchange")
    fun deteleAll()

    @Update
    fun updateExchange(exchange: Exchange)
}