package com.example.rtc_currency.utils

import android.app.Dialog
import android.content.Context
import android.view.ViewGroup.LayoutParams
import com.example.rtc_currency.R
import kotlinx.android.synthetic.main.dialog_ok.*

class Dialog {

    companion object {
        fun showOk(context: Context, textTitle: String, textDescription: String, onClickOk: () -> Unit) {
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.dialog_ok)

            dialog.text_title.text = textTitle
            dialog.text_description.text = textDescription

            dialog.button_ok.setOnClickListener {
                onClickOk()
            }

            dialog.window!!.setLayout(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

            dialog.show()
        }
    }
}