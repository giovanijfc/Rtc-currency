package com.example.rtc_currency.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.rtc_currency.R
import com.example.rtc_currency.database.models.Exchange
import com.example.rtc_currency.ui.view_model.HomeViewModel
import com.example.rtc_currency.ui.view_model.ListCoinsViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_exchange_item.view.*

class CoinsHighlightItemListAdapter(
    private var exchanges: List<Exchange>?,
    private val context: Context,
    private val viewModel: ListCoinsViewModel?
) :
    RecyclerView.Adapter<CoinsHighlightItemListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val exchangeItemView =
            LayoutInflater.from(context).inflate(R.layout.adapter_exchange_item, parent, false)

        return ViewHolder(exchangeItemView)
    }


    override fun onBindViewHolder(exchangeItemAdapterView: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return exchanges!!.size
    }

    class ViewHolder(exchangeItemAdapterView: View) :
        RecyclerView.ViewHolder(exchangeItemAdapterView) {
    }
}