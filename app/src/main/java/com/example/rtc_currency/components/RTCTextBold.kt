package com.example.rtc_currency.components

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class RTCTextBold(context: Context, attrs: AttributeSet) : AppCompatTextView(context, attrs) {

    init {
        setTypeface(Typeface.SANS_SERIF, Typeface.BOLD)
    }
}