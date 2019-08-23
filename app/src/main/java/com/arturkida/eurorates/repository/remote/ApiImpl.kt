package com.arturkida.eurorates.repository.remote

import android.arch.lifecycle.MutableLiveData
import android.os.Handler
import com.arturkida.eurorates.BuildConfig
import com.arturkida.eurorates.idlingresource.EspressoIdlingResource
import com.arturkida.eurorates.model.Currency
import com.arturkida.eurorates.repository.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiImpl {

    private val currency = MutableLiveData<Resource<Currency?>>()
    private val retrofit: Api = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Api::class.java)

    fun getCurrencies() : MutableLiveData<Resource<Currency?>> {

        EspressoIdlingResource.increment()

        val handler = Handler()
        val defaultDelay = 60000L
        val doNotWaitToRun = 0L

        handler.postDelayed(object : Runnable {
            override fun run() {
                callApi()

                handler.postDelayed(this, defaultDelay)
            }
        }, doNotWaitToRun)

        return currency
    }

    private fun callApi() {
        val call = retrofit.getCurrencyRates()

        call.enqueue(object : Callback<Currency?> {
            override fun onFailure(call: Call<Currency?>, t: Throwable) {
                currency.value = Resource(data = currency.value?.data, error = t)
                EspressoIdlingResource.decrement()
            }

            override fun onResponse(call: Call<Currency?>, response: Response<Currency?>) {
                currency.value = Resource(data = response.body())
                EspressoIdlingResource.decrement()
            }
        })
    }
}