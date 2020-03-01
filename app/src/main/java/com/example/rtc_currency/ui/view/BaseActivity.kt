package com.example.rtc_currency.ui.view

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.rtc_currency.R
import kotlinx.android.synthetic.main.component_toolbar_search.view.*

open class BaseActivity : AppCompatActivity() {

    fun setToolbar(toolbar: Toolbar, textTitle: String) {
        toolbar.text_title.text = textTitle
        setSupportActionBar(toolbar)
    }
}