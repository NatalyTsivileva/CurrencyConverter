package com.example.currencyconverter.di

import com.example.currencyconverter.domain.repository.CurrenciesRepository
import com.example.currencyconverter.domain.repository.CurrenciesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindCurrenciesRepository(impl: CurrenciesRepositoryImpl): CurrenciesRepository
}