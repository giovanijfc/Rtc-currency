package com.example.rtc_currency.ui.view

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
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
import kotlinx.android.synthetic.main.component_toolbar_back.view.*

class ListCoinsActivity : BaseActivity() {

    var listCoinsViewModel: ListCoinsViewModel? = null
    var exchange: Exchange? = null
    var coinsHighlightItemListAdapter: CoinsHighlightItemListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_coins)

        exchange = intent.getParcelableExtra("EXCHANGE")

        exchange?.name?.let { name ->
            setToolbar(toolbar_coins as Toolbar, name, true)
        }

        listCoinsViewModel = ViewModelProvider(this).get(ListCoinsViewModel::class.java)

        listCoinsViewModel?.setExchange(exchange)

        listCoinsViewModel?.exchangeCoins?.observe(this, Observer { exchangeCoins ->
            var coinsHighlight = exchangeCoins?.coins?.filterIndexed { position, coin ->
                position < 4
            }

            configCoinsHighlightList(coinsHighlight)

            loading.visibility = View.GONE
            area_highlight_currency.visibility = View.VISIBLE
        })
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_title_ic_back, menu)

        return super.onPrepareOptionsMenu(menu)
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
