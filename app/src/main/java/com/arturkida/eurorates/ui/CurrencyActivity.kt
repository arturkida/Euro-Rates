package com.arturkida.eurorates.ui

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.arturkida.eurorates.R
import com.arturkida.eurorates.model.Currency
import com.arturkida.eurorates.viewmodel.CurrencyViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class CurrencyActivity : AppCompatActivity() {

    private val viewModel by viewModel<CurrencyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getCurrencies()
    }

    fun getCurrencies() {
        viewModel.getCurrencies().observe(this, Observer {currencies ->
            currencies?.data?.let {

            }
            currencies?.error?.let {
                showErrorMessage()
            }
        })
    }

    private fun showErrorMessage() {
        Toast.makeText(this, getString(R.string.errorMessage), Toast.LENGTH_SHORT).show()
    }
}
