package com.example.currencyconverter.domain.repository

import com.example.currencyconverter.data.dataSource.remote.RatesService
import com.example.currencyconverter.data.dataSource.room.ConverterDatabase
import javax.inject.Inject

class CurrenciesRepositoryImpl @Inject constructor(
    private val database: ConverterDatabase,
    private val remote:RatesService
): CurrenciesRepository {


}