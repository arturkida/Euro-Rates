package com.arturkida.eurorates.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.arturkida.eurorates.model.Currency
import com.arturkida.eurorates.repository.Resource
import com.arturkida.eurorates.repository.remote.ApiImpl

class CurrencyViewModel(
    private val apiImpl: ApiImpl
) : ViewModel() {

    fun getCurrencies(): MutableLiveData<Resource<Currency?>> = apiImpl.getCurrencies()

}