package com.example.rtc_currency.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.rtc_currency.enums.StepsInfoEnum

class StepsInfoPagerAdapter(private val context: Context): PagerAdapter() {

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val step = StepsInfoEnum.values()[position]
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(step.layoutResId, collection, false)
        collection.addView(layout)
        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun isViewFromObject(view: View, `object`: Any) = view === `object`

    override fun getCount() = StepsInfoEnum.values().size

}