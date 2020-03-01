package com.example.rtc_currency.ui.view.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.rtc_currency.Preferences
import com.example.rtc_currency.enums.StepsInfoEnum
import com.example.rtc_currency.ui.view.HomeActivity
import kotlinx.android.synthetic.main.fragment_steps_info_one.view.*

class StepsInfoPagerAdapter(private val context: Context, private val viewPager: ViewPager) : PagerAdapter() {

    private val preferences = Preferences(context);

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val step = StepsInfoEnum.values()[position]
        val inflater = LayoutInflater.from(context)
        val layout = inflater.inflate(step.layoutResId, collection, false)

        layout.button_next.setOnClickListener {
            when (position) {
                0 -> viewPager.setCurrentItem(position + 1, true)
                1 -> viewPager.setCurrentItem(position + 1, true)
                2 -> {
                    preferences.setIsFirstInitialization(false)

                    val homeIntent = Intent(context, HomeActivity::class.java)
                    homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    context.startActivity(homeIntent)
                }
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