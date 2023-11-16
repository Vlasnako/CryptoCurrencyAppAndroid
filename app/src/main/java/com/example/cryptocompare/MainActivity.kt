package com.example.cryptocompare

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R


class MainActivity : ComponentActivity() {
    private lateinit var viewModel: CoinViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
//        viewModel.priceList.observe(this) {
//            Log.d("TEST_OF_LOADING_DATA", "Success in activity: $it")
//        }
        viewModel.getDetailInfo("BTC").observe(this) {
            Log.d("TEST_OF_LOADING_DATA", "Success in activity: $it")
        }
    }

}

