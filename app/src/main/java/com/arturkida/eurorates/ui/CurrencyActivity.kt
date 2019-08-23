package com.arturkida.eurorates.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.arturkida.eurorates.R
import com.arturkida.eurorates.viewmodel.CurrencyViewModel
import kotlinx.android.synthetic.main.activity_currency.*
import org.koin.android.viewmodel.ext.android.viewModel


class CurrencyActivity : AppCompatActivity() {

    private val viewModel by viewModel<CurrencyViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)

        getCurrencies()
    }

    private fun getCurrencies() {
        viewModel.getCurrencies().observe(this, Observer {currencies ->
            currencies?.data?.let {currency ->
                tv_usd_value.text = currency.rates.USD.toString()
                tv_pln_value.text = currency.rates.PLN.toString()
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
