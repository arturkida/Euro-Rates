package com.arturkida.eurorates.model

data class Currency(
    val base: String,
    val date: String,
    val rates: Rates
)