package com.example.rtc_currency.ui.view

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
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

class HomeActivity : BaseActivity() {

    var homeViewModel: HomeViewModel? = null
    var exchangeItemListAdapter: ExchangesItemListAdapter? = null

    var isListFavoriteListExchange: Boolean = false
    var textSearch: String? = ""

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

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar_search, menu)

        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val buttonSearch = menu?.findItem(R.id.button_search)
        val searchView = buttonSearch?.actionView as SearchView
        val buttonListFavoriteExchanges = menu?.findItem(R.id.button_list_favourites)

        searchView.setBackgroundColor(
            ContextCompat.getColor(
                this@HomeActivity,
                R.color.colorPrimaryDark
            )
        )

        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newTextSearch: String?): Boolean {
                textSearch = newTextSearch

                homeViewModel?.onChangeTextSearch("%$newTextSearch%", isListFavoriteListExchange)
                return true
            }

            override fun onQueryTextSubmit(newTextSearch: String?): Boolean {
                textSearch = newTextSearch

                homeViewModel?.onChangeTextSearch("%$newTextSearch%", isListFavoriteListExchange)
                return false
            }
        })

        buttonListFavoriteExchanges.setOnMenuItemClickListener {
            isListFavoriteListExchange = !isListFavoriteListExchange
            buttonListFavoriteExchanges.icon = when {
                isListFavoriteListExchange -> ContextCompat.getDrawable(
                    this@HomeActivity,
                    R.drawable.ic_star
                )
                else -> ContextCompat.getDrawable(this@HomeActivity, R.drawable.ic_star_empty)
            }

            buttonSearch.collapseActionView()
            homeViewModel?.onClickListExchangesFavorites(isListFavoriteListExchange)

            return@setOnMenuItemClickListener true
        }

        buttonSearch.collapseActionView()

        return super.onPrepareOptionsMenu(menu)
    }

    private fun configExchangeList(exchanges: List<Exchange>?) {
        exchangeItemListAdapter = ExchangesItemListAdapter(exchanges, this, homeViewModel)
        recycle_list_exchange.adapter = exchangeItemListAdapter
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycle_list_exchange.layoutManager = layoutManager
    }

    private fun onChangeListExchangeObserver() {
        homeViewModel?.exchanges?.observe(this, androidx.lifecycle.Observer { exchangesUpdate ->
            exchangeItemListAdapter?.setExchanges(exchangesUpdate)
        })
    }
}
