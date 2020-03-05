package com.example.rtc_currency.components

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.rtc_currency.R

class RTCButtonDialog(context: Context, attrs: AttributeSet) :
    AppCompatButton(context, attrs) {

    init {
        setTextColor(ContextCompat.getColor(context, R.color.white))
        setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
    }
}