package com.arturkida.eurorates

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arturkida.eurorates.model.Currency
import com.arturkida.eurorates.repository.ApiImpl

class MainActivity : AppCompatActivity() {

    private val apiImpl = ApiImpl()
    private lateinit var currency: Currency

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getCurrencies()
    }

    fun getCurrencies() {
        apiImpl.getCurrencies().observe(this, Observer {currencies ->
            currencies?.let {
                currency = it
                Log.i("currency", currency.toString())
            }
        })
    }
}
