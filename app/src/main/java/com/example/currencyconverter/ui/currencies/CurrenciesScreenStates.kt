package com.example.currencyconverter.ui.currencies

import com.example.currencyconverter.ui.data.Currency

sealed class CurrenciesScreenStates
data object Initial : CurrenciesScreenStates()
class Success(val data: List<Currency>) : CurrenciesScreenStates()
class Failed(val message: String?) : CurrenciesScreenStates()
