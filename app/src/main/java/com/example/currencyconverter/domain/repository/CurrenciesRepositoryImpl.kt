package com.example.currencyconverter.domain.repository

import com.example.currencyconverter.data.dataSource.remote.RatesService
import com.example.currencyconverter.data.dataSource.room.ConverterDatabase
import com.example.currencyconverter.data.mapper.CurrencyMapper
import com.example.currencyconverter.ui.data.Currency
import javax.inject.Inject

class CurrenciesRepositoryImpl @Inject constructor(
    private val database: ConverterDatabase,
    private val remote: RatesService
) : CurrenciesRepository {

    override suspend fun getCurrencies(baseCurrencyCode: String, amount: Double): List<Currency> {
        val remoteData = remote.getRates(baseCurrencyCode = baseCurrencyCode, amount = amount)
        val localData = database.accountDao().getAll()

        return remoteData.map {
            val amountOnAccount = localData.find { it.code ==  baseCurrencyCode }
            CurrencyMapper.mapRemoteCurrency(rateDto = it, amount = amountOnAccount?.amount)
        }
    }
}