package com.example.currencyconverter.ui.list

import com.example.currencyconverter.ui.data.Currency

interface CurrenciesClickListener {

    fun onCurrencyCardClickListener(currency: Currency)

    fun onAmountTextChanged(amount:Double)
}