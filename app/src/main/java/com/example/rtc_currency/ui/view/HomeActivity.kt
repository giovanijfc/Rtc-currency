package com.example.rtc_currency.ui.view

import android.app.SearchManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.rtc_currency.R
import com.example.rtc_currency.ui.view_model.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.component_toolbar_search.view.*

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setToolbar(toolbar as Toolbar, getString(R.string.exchanges))

        val homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        homeViewModel.checkFirstInitializationApp()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar_search, menu)

        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val buttonSearch = menu?.findItem(R.id.button_search)
        val searchView = buttonSearch?.actionView as SearchView
        searchView.setBackgroundColor(ContextCompat.getColor(this@HomeActivity, R.color.colorPrimaryDark))
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
