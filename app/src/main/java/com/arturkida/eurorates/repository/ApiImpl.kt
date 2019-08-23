package com.arturkida.eurorates.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.arturkida.eurorates.BuildConfig
import com.arturkida.eurorates.model.Currency
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiImpl {

    private val currency = MutableLiveData<Currency?>()

    companion object {
        val retrofit: Api = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    fun getCurrencies() : LiveData<Currency?> {
        val call = retrofit.getCurrencyRates()

        call.enqueue(object : Callback<Currency?> {
            override fun onFailure(call: Call<Currency?>, t: Throwable) {
                Log.i("currency", "deu ruim")
            }

            override fun onResponse(call: Call<Currency?>, response: Response<Currency?>) {
                currency.value = response.body()
            }
        })

        return currency
    }
}