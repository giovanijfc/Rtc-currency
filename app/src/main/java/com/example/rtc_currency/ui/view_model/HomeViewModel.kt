package com.example.rtc_currency.ui.view_model

import android.app.Application
import android.content.Context
import android.content.Intent
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
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

    fun onChangeTextSearch(textSearch: String?, isListFavoriteExchange: Boolean) {
        Thread {
            val exchangesByName = when {
                isListFavoriteExchange -> db!!.exchangeDAO().getByNameAndIsFavorite(
                    textSearch,
                    true
                )
                else -> db?.exchangeDAO()?.getByName(textSearch)
            }

            setExchanges(exchangesByName)
        }.start()
    }

    fun onClickListExchangesFavorites(isListFavoriteExchange: Boolean) {
        Thread {
            val exchangesUpdated = when {
                isListFavoriteExchange -> db!!.exchangeDAO().getByNameAndIsFavorite(
                    "%%",
                    true
                )
                else -> db?.exchangeDAO()?.getAll()
            }

            setExchanges(exchangesUpdated)
        }.start()
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
}