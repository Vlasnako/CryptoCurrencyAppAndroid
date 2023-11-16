package com.example.cryptocompare.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptocompare.pojo.CoinPriceInfo
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemCoinInfoBinding
import com.squareup.picasso.Picasso

class CoinInfoAdapter: RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {
    var coinInfoList: List<CoinPriceInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    inner class CoinInfoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemCoinInfoBinding.bind(itemView)
        val ivLogoCoin = binding.ivLogoCoin
        val tvSymbols = binding.tvSymbols
        val tvPrice = binding.tvPrice
        val tvLastUpdate = binding.tvLastUpdated
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coin_info, parent, false)
        return CoinInfoViewHolder(view)
    }

    override fun getItemCount() = coinInfoList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coinInfoList[position]
        with(holder) {
            with (coin) {
                tvSymbols.text = "$fromsymbol / $tosymbol"
                tvPrice.text = price.toString()
                tvLastUpdate.text = getFormattedTime()
                Picasso.get().load(getFullImageUrl()).into(ivLogoCoin)
            }
        }
    }
}