package com.example.rtc_currency.ui.view

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.LayoutDirection
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.rtc_currency.R
import com.example.rtc_currency.database.models.Exchange
import com.example.rtc_currency.ui.view.adapter.ExchangesItemListAdapter
import com.example.rtc_currency.ui.view_model.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.activity_home)

        setToolbar(toolbar as Toolbar, getString(R.string.exchanges))

        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.checkFirstInitializationApp()

        val exchanges = intent.extras?.getParcelableArrayList<Exchange>("EXCHANGES") as List<Exchange>
        configExchangeList(exchanges)
    }

    private fun configExchangeList(exchanges: List<Exchange>) {
        val recyclerView = recycle_list_exchange
        recyclerView.adapter = ExchangesItemListAdapter(exchanges, this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)
        recyclerView.layoutManager = layoutManager
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
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.i("NEW_TEXT", newText)
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                buttonSearch.collapseActionView()
                Log.i("ONSUBMIT", query)
                return false
            }
        })

        buttonSearch.collapseActionView()

        return super.onPrepareOptionsMenu(menu)
    }
}
