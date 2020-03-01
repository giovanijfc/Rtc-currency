package com.example.rtc_currency.ui.view.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.rtc_currency.enums.StepsInfoEnum
import kotlinx.android.synthetic.main.fragment_steps_info_one.view.*

class StepsInfoPagerAdapter(private val context: Context, private val viewPager: ViewPager) : PagerAdapter() {

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val step = StepsInfoEnum.values()[position]
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(step.layoutResId, collection, false)

        layout.button_next.setOnClickListener {
            when (position) {
                0 -> viewPager.setCurrentItem(position + 1, true)
                1 -> viewPager.setCurrentItem(position + 1, true)
                2 -> Log.i("POSITION", "2")
            }
        }

        collection.addView(layout)

        return layout
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun isViewFromObject(view: View, `object`: Any) = view === `object`

    override fun getCount() = StepsInfoEnum.values().size
}