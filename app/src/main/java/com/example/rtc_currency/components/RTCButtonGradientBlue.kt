package com.example.rtc_currency.components

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.rtc_currency.R

class RTCButtonGradientBlue(context: Context, attrs: AttributeSet) :
    AppCompatButton(context, attrs) {

    init {
        setTextColor(ContextCompat.getColor(context, R.color.white))
        setBackgroundDrawable(
            ContextCompat.getDrawable(
                context,
                R.drawable.shape_button_gradient_blue_rounded
            )
        )
    }
}