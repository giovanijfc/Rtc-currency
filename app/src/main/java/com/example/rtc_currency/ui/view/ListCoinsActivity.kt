package com.example.rtc_currency.ui.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rtc_currency.R
import com.example.rtc_currency.database.models.Coin
import com.example.rtc_currency.database.models.Exchange
import com.example.rtc_currency.database.models.ExchangeCoins
import com.example.rtc_currency.ui.view.adapter.CoinsHighlightItemListAdapter
import com.example.rtc_currency.ui.view.adapter.ExchangesItemListAdapter
import com.example.rtc_currency.ui.view_model.ListCoinsViewModel
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_list_coins.*

class ListCoinsActivity : AppCompatActivity() {

    var listCoinsViewModel: ListCoinsViewModel? = null
    var exchange: Exchange? = null
    var coinsHighlightItemListAdapter: CoinsHighlightItemListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_coins)

        exchange = intent.getParcelableExtra("EXCHANGE")
        listCoinsViewModel = ViewModelProvider(this).get(ListCoinsViewModel::class.java)

        listCoinsViewModel?.setExchange(exchange)

        listCoinsViewModel?.exchangeCoins?.observe(this, Observer { exchangeCoins ->
            var coinsHighlight = exchangeCoins?.coins?.filterIndexed { position, coin ->
                position < 4
            }

            Log.i("CoinsHighLight", coinsHighlight.toString())

            configCoinsHighlightList(coinsHighlight)
        })
    }

    private fun configCoinsHighlightList(coins: List<Coin>?) {
        coinsHighlightItemListAdapter =
            CoinsHighlightItemListAdapter(coins, this, listCoinsViewModel)
        coin_highlight_recycle_view.setScrollingTouchSlop(5)
        coin_highlight_recycle_view.adapter = coinsHighlightItemListAdapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        coin_highlight_recycle_view.layoutManager = layoutManager
    }
}
