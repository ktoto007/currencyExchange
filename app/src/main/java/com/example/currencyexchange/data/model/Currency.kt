package com.example.currencyexchange.data.model

data class CurrencyResponse(
    val exchangeRate: List<Currency>
)

data class Currency(
    val currency: String,
    val saleRate: Double?
)
