package com.example.rtc_currency.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rtc_currency.R
import com.example.rtc_currency.ui.view.adapter.StepsInfoPagerAdapter
import kotlinx.android.synthetic.main.activity_steps_info.*

class StepsInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_steps_info)

        view_pager.adapter = StepsInfoPagerAdapter(this, view_pager)
    }

    override fun onBackPressed() {
        if (view_pager.currentItem > 0) {
            view_pager.setCurrentItem(view_pager.currentItem - 1, true)
        } else {
            super.onBackPressed()
        }
    }
}