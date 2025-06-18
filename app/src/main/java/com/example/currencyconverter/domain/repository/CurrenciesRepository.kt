package com.example.currencyconverter.domain.repository

import com.example.currencyconverter.ui.data.Currency

interface CurrenciesRepository {
    suspend fun getCurrencies(baseCurrencyCode: String, amount: Double): List<Currency>
}