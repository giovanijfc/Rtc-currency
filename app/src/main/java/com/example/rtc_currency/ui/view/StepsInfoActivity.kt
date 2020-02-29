package com.example.rtc_currency.ui.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.rtc_currency.R
import com.example.rtc_currency.ui.view.adapter.StepsInfoPagerAdapter
import kotlinx.android.synthetic.main.activity_steps_info.*

class StepsInfoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_steps_info)

        view_pager.adapter = StepsInfoPagerAdapter(this)

        Thread {
            Thread.sleep(2000)
            runOnUiThread {
                Log.d("LOG ITEM", view_pager.currentItem.toString())
                view_pager.setCurrentItem(0, true)
            }
        }.start()
    }
}