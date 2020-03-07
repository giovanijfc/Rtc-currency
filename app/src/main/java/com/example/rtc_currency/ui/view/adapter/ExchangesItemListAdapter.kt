package com.example.rtc_currency.ui.view.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.rtc_currency.R
import com.example.rtc_currency.database.models.Exchange
import com.example.rtc_currency.ui.view.HomeActivity
import com.example.rtc_currency.ui.view_model.HomeViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.adapter_exchange_item.view.*
import java.util.ArrayList

class ExchangesItemListAdapter(
    private var exchanges: List<Exchange>?,
    private val context: Context,
    private val viewModel: HomeViewModel?
) :
    RecyclerView.Adapter<ExchangesItemListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val exchangeItemView =
            LayoutInflater.from(context).inflate(R.layout.adapter_exchange_item, parent, false)

        return ViewHolder(exchangeItemView)
    }


    override fun onBindViewHolder(exchangeItemAdapterView: ViewHolder, position: Int) {
        val exchange = exchanges?.get(position)

        exchangeItemAdapterView?.textName.text = exchange?.name!!.replace("/ /g", "")
        exchangeItemAdapterView?.textRank.text = exchange.trustScoreRank.toString()
        exchangeItemAdapterView?.yearFoundedIn.text =
            if (exchange.yearEstablised == null) "N/A" else exchange.yearEstablised.toString()
        exchangeItemAdapterView?.live_at.text =
            if (exchange.country == null) "N/A" else exchange.country.toString()

        if (exchange.image !== null) {
            Picasso.with(context)
                .load(exchange.image)
                .into(exchangeItemAdapterView.imageLogo);
        }

        val isFavoriteImage = when {
            exchange.isFavorite -> ContextCompat.getDrawable(context, R.drawable.ic_star)
            else -> ContextCompat.getDrawable(context, R.drawable.ic_star_empty)
        }

        exchangeItemAdapterView.imageFavorite.setImageDrawable(isFavoriteImage)

        exchangeItemAdapterView.imageFavorite.setOnClickListener {
            viewModel?.setIsFavorite(position, !exchange.isFavorite)
        }

        exchangeItemAdapterView.mainLayout.setOnClickListener {
            viewModel?.toActivityCoinsList(context, exchange)
        }
    }

    override fun getItemCount(): Int {
        return exchanges!!.size
    }

    class ViewHolder(exchangeItemAdapterView: View) :
        RecyclerView.ViewHolder(exchangeItemAdapterView) {
        val textName = exchangeItemAdapterView.text_name
        val imageLogo = exchangeItemAdapterView.image_logo
        val textRank = exchangeItemAdapterView.text_rank
        val yearFoundedIn = exchangeItemAdapterView.text_year_founded
        val live_at = exchangeItemAdapterView.text_live_at
        val imageFavorite = exchangeItemAdapterView.image_favorite
        val mainLayout = exchangeItemAdapterView.main_layout
    }

    fun setExchanges(exchangesUpdated: List<Exchange>?) {
        exchanges = exchangesUpdated
        notifyDataSetChanged()
    }
}