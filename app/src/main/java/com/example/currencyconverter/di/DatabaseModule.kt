package com.example.currencyconverter.di

import android.content.Context
import androidx.room.Room
import com.example.currencyconverter.data.dataSource.room.ConverterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): ConverterDatabase {
        return Room.databaseBuilder(
            appContext, ConverterDatabase::class.java, "CurrencyDatabase.db"
        ).createFromAsset("databases/converter.db")
            .build()
    }

}