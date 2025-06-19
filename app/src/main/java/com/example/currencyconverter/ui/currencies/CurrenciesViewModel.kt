package com.example.currencyconverter.ui.currencies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.domain.repository.CurrenciesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrenciesViewModel @Inject constructor(
    private val repository: CurrenciesRepository
) : ViewModel() {

    var currencyFromAbbr = "EUR"
        private set

    var currencyFromAmount = 1.0
        private set

    private var job: Job? = null

    private val currenciesMutableFlow: MutableStateFlow<CurrenciesScreenStates> =
        MutableStateFlow(Initial)

    val currencyStateFlow = currenciesMutableFlow.asStateFlow()

    init {
        job = viewModelScope.launch {
            while (job?.isActive == true) {
                getCurrencies(currencyFromAbbr, currencyFromAmount)
                delay(1_000)
            }
        }
    }

    suspend fun getCurrencies(countryCode: String, amount: Double) {
        try {
            currencyFromAmount = amount
            currencyFromAbbr = countryCode

            val currencies = repository.getCurrencies(countryCode, amount)
            currenciesMutableFlow.emit(Success(currencies))
        } catch (t: Throwable) {
            currenciesMutableFlow.emit(Failed(t.message))
        }
    }

    fun onFromCurrencyChanged(currency:String){
        currencyFromAbbr = currency
    }

    fun onFromCurrencyAmountChanged(amount:Double){
        currencyFromAmount = amount
    }

}