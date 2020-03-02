package com.example.rtc_currency.components

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.rtc_currency.R

class RTCText(context: Context, attrs: AttributeSet) : AppCompatTextView(context, attrs) {

    init {
        setTextColor(ContextCompat.getColor(context, R.color.white))
    }
}