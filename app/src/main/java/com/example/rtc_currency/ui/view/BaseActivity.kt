package com.example.rtc_currency.ui.view

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.component_toolbar_back.view.*

open class BaseActivity : AppCompatActivity() {

    fun setToolbar(toolbar: Toolbar, textTitle: String, haveCustomTitle: Boolean) {
        if (haveCustomTitle) {
            toolbar.text_title.text = textTitle
            toolbar.title = ""
            toolbar.button_back.setOnClickListener { finish() }
            setSupportActionBar(toolbar)
        } else {
            toolbar.title = textTitle
            setSupportActionBar(toolbar)
        }
    }
}