package com.example.rtc_currency.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rtc_currency.database.dao.ExchangeDAO
import com.example.rtc_currency.database.models.Exchange

@Database(entities = arrayOf(Exchange::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun exchangeDAO(): ExchangeDAO

    companion object {
        var INSTANCE: AppDatabase? = null
        private val NAME_DB = "app-database";

        fun getDB(application: Application): AppDatabase? {
            if (INSTANCE === null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        application,
                        AppDatabase::class.java,
                        NAME_DB
                    ).build()
                }
            }
            return INSTANCE
        }

        fun destroyDB() {
            INSTANCE = null
        }
    }

}