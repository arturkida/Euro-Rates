package com.arturkida.eurorates.di.modules

import com.arturkida.eurorates.repository.remote.ApiImpl
import com.arturkida.eurorates.viewmodel.CurrencyViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module {
    single<ApiImpl> {
        ApiImpl()
    }
    viewModel<CurrencyViewModel> {
        CurrencyViewModel(get())
    }
}