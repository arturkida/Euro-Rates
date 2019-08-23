package com.arturkida.eurorates.repository.remote

import com.arturkida.eurorates.BuildConfig
import com.arturkida.eurorates.model.Currency
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET(BuildConfig.LATEST)
    fun getCurrencyRates() : Call<Currency>
}