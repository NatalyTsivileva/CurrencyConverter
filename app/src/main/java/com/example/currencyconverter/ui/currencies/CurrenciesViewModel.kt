package com.example.currencyconverter.ui.currencies

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.domain.repository.CurrenciesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrenciesViewModel @Inject constructor(
    private val repository: CurrenciesRepository
) : ViewModel() {

    private val currenciesMutableFlow: MutableStateFlow<CurrenciesScreenStates> =
        MutableStateFlow(Initial)

    val currencyStateFlow= currenciesMutableFlow.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val currencies=repository.getCurrencies("RUB", 1.0)
                currenciesMutableFlow.emit(Success(currencies))
            } catch (t: Throwable) {
                currenciesMutableFlow.emit(Failed(t.message))
            }
        }
    }

}