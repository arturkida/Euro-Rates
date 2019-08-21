package com.arturkida.eurorates.repository

import com.arturkida.eurorates.BuildConfig
import com.arturkida.eurorates.model.Currency
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET(BuildConfig.CURRENCY_RATES_URL)
    fun getCurrencyRates() : Call<Currency>
}