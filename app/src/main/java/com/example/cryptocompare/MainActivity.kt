package com.example.cryptocompare

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R


class MainActivity : ComponentActivity() {
    private lateinit var viewModel: CoinViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.loadData()
    }

}

