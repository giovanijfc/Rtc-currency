package com.example.rtc_currency.ui.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rtc_currency.database.models.Exchange

class ExchangesItemListAdapter(private val exchanges: Collection<Exchange>) :
    RecyclerView.Adapter<ExchangesItemListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented")
    }

    override fun getItemCount(): Int {
        return exchanges.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}