package com.example.rtc_currency.ui.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rtc_currency.R
import com.example.rtc_currency.database.models.Coin
import com.example.rtc_currency.database.models.Exchange
import com.example.rtc_currency.ui.view_model.ListCoinsViewModel
import kotlinx.android.synthetic.main.adapter_coins_highligth.view.*
import kotlinx.android.synthetic.main.adapter_exchange_item.view.*

class CoinsHighlightItemListAdapter(
    private var coins: List<Coin>?,
    private val context: Context,
    private val viewModel: ListCoinsViewModel?
) :
    RecyclerView.Adapter<CoinsHighlightItemListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val coinHighlightView =
            LayoutInflater.from(context).inflate(R.layout.adapter_coins_highligth, parent, false)

        return ViewHolder(coinHighlightView)
    }


    override fun onBindViewHolder(coinHighlightAdapterView: ViewHolder, position: Int) {
        val coin = coins?.get(position)

        coinHighlightAdapterView.textName.text = coin?.base + "/" + coin?.target
        coinHighlightAdapterView.lastPrice.text = coin?.lastPrice
    }

    override fun getItemCount(): Int {
        return coins!!.size
    }

    class ViewHolder(coinHighlightAdapterView: View) :
        RecyclerView.ViewHolder(coinHighlightAdapterView) {
        val image = coinHighlightAdapterView.image_currecy
        val textName = coinHighlightAdapterView.text_name_currency
        val lastPrice = coinHighlightAdapterView.last_price
    }
}