package com.example.rtc_currency.ui.view

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rtc_currency.R
import com.example.rtc_currency.database.models.Exchange
import com.example.rtc_currency.ui.view.adapter.ExchangesItemListAdapter
import com.example.rtc_currency.ui.view_model.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*
import java.util.Observer

class HomeActivity : BaseActivity() {

    var homeViewModel: HomeViewModel? = null
    var exchangeItemListAdapter: ExchangesItemListAdapter? = null

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_home)

        setToolbar(toolbar as Toolbar, getString(R.string.exchanges))

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel?.checkFirstInitializationApp()

        val exchanges =
            intent.extras?.getParcelableArrayList<Exchange>("EXCHANGES") as List<Exchange>
        homeViewModel?.setExchanges(exchanges)

        homeViewModel?.exchanges?.observe(this, androidx.lifecycle.Observer { exchangesUpdated ->
            configExchangeList(exchangesUpdated?.toList())
            homeViewModel?.exchanges?.removeObservers(this)
            onChangeListExchangeObserver()
        })
    }

    private fun configExchangeList(exchanges: List<Exchange>?) {
        exchangeItemListAdapter = ExchangesItemListAdapter(exchanges, this, homeViewModel)
        recycle_list_exchange.adapter = exchangeItemListAdapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycle_list_exchange.layoutManager = layoutManager
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar_search, menu)

        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val buttonSearch = menu?.findItem(R.id.button_search)
        val searchView = buttonSearch?.actionView as SearchView
        searchView.setBackgroundColor(
            ContextCompat.getColor(
                this@HomeActivity,
                R.color.colorPrimaryDark
            )
        )
        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(textSearch: String?): Boolean {
                homeViewModel?.onChangeTextSearch("%$textSearch%")
                return true
            }

            override fun onQueryTextSubmit(textSearch: String?): Boolean {
                homeViewModel?.onChangeTextSearch("%$textSearch%")
                return false
            }
        })

        buttonSearch.collapseActionView()

        return super.onPrepareOptionsMenu(menu)
    }

    private fun onChangeListExchangeObserver() {
        homeViewModel?.exchanges?.observe(this, androidx.lifecycle.Observer { exchangesByName ->
            exchangeItemListAdapter?.setExchanges(exchangesByName)
        })
    }
}
