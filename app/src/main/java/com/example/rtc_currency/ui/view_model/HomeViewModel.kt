package com.example.rtc_currency.ui.view_model

import android.app.Application
import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.rtc_currency.Preferences
import com.example.rtc_currency.database.AppDatabase
import com.example.rtc_currency.database.models.Exchange
import com.example.rtc_currency.ui.view.StepsInfoActivity

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val context: Context = getApplication<Application>().applicationContext
    private var db: AppDatabase? = null
    var exchanges = MutableLiveData<List<Exchange>?>()

    init {
        db = AppDatabase.getDB(application)
    }

    fun checkFirstInitializationApp() {
        val preferences = Preferences(context)
        val isFirstInitialization = preferences.isFirstInitialization()

        if (isFirstInitialization) {
            val stepsInfoIntent = Intent(context, StepsInfoActivity::class.java)
            stepsInfoIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            stepsInfoIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            context.startActivity(stepsInfoIntent)
        }
    }

    fun setExchanges(exchangesToUpdate: List<Exchange>?) {
        exchanges.postValue(exchangesToUpdate);
    }

    fun setIsFavorite(position: Int, isFavorite: Boolean) {
        exchanges.value!![position].isFavorite = isFavorite
        Thread {
            db?.exchangeDAO()?.updateExchange(exchanges.value!![position])
            setExchanges(exchanges.value)
        }.start()
    }

    fun onChangeTextSearch(textSearch: String?) {
        Thread {
            val exchangesByName = when {
                textSearch?.length === 0 -> db!!.exchangeDAO().getAll()
                else -> db?.exchangeDAO()?.getByName(textSearch)
            }

            setExchanges(exchangesByName)
        }.start()
    }
}