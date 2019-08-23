package com.arturkida.eurorates.viewmodel

import android.arch.lifecycle.ViewModel
import com.arturkida.eurorates.repository.ApiImpl

class CurrencyViewModel(private val apiImpl: ApiImpl) : ViewModel() {

    fun getCurrencies() = apiImpl.getCurrencies()

}