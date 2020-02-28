package com.example.rtc_currency.enums

import com.example.rtc_currency.R

enum class StepsInfoEnum(val page: Int, val layoutResId: Int) {
    FIRST_PAGE(0, R.layout.fragment_one),
    SECOND_PAGE(1, R.layout.fragment_two),
    THREE_PAGE(2, R.layout.fragment_three)
}