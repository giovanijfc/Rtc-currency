package com.example.rtc_currency.ui.view

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

open class BaseActivity : AppCompatActivity() {

    fun setToolbar(toolbar: Toolbar, textTitle: String) {
        toolbar.title = textTitle
        setSupportActionBar(toolbar)
    }
}