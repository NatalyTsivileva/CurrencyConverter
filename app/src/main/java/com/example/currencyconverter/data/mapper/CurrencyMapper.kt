package com.example.currencyconverter.data.mapper

import com.example.currencyconverter.R
import com.example.currencyconverter.data.dataSource.remote.dto.RateDto
import com.example.currencyconverter.ui.data.Currency

object CurrencyMapper {
    fun mapRemoteCurrency(rateDto: RateDto, amount: Double?) =
        Currency(
            name = mapName(rateDto),
            flag = mapFlag(rateDto),
            abbreviation = rateDto.currency,
            course = rateDto.value,
            sign = mapSign(rateDto),
            amount = amount
        )

    private fun mapName(dto: RateDto): String {
        return when (dto.currency) {
            "EUR" -> "Euro"
            "AUD" -> "Australian dollar"
            "BGN" -> "Bulgarian lev"
            "BRL" -> "Brazilian real"
            "CAD" -> "Canadian dollar"
            "CHF" -> "Swiss franc"
            "CNY" -> "Chinese yuan"
            "CZK" -> "Czech koruna"
            "DKK" -> "Danish krone"
            "GBP" -> "British pound"
            "HKD" -> "Hong Kong dollar"
            "HRK" -> "Croatian kuna"
            "HUF" -> "Hungarian forint"
            "IDR" -> "Indonesian rupiah"
            "ILS" -> "Israeli new shekel"
            "INR" -> "Indian rupee"
            "ISK" -> "Icelandic króna"
            "JPY" -> "Japanese yen"
            "KRW" -> "South Korean won"
            "MXN" -> "Mexican peso"
            "MYR" -> "Malaysian ringgit"
            "NOK" -> "Norwegian krone"
            "NZD" -> "New Zealand dollar"
            "PHP" -> "Philippine peso"
            "PLN" -> "Polish złoty"
            "RON" -> "Romanian leu"
            "RUB" -> "Russian ruble"
            "SEK" -> "Swedish krona"
            "SGD" -> "Singapore dollar"
            "THB" -> "Thai baht"
            "TRY" -> "Turkish lira"
            "USD" -> "United States dollar"
            "ZAR" -> "South African rand"
            else -> "Unknown currency"
        }
    }

    private fun mapFlag(dto: RateDto):Int{
        return when(dto.currency){
            "EUR"-> R.drawable.icon_eur
            "AUD" -> R.drawable.icon_aud
            "BGN" -> R.drawable.icon_bgn
            "BRL" -> R.drawable.icon_brl
            "CAD" -> R.drawable.icon_cad
            "CHF" -> R.drawable.icon_chf
            "CNY" -> R.drawable.icon_cny
            "CZK" -> R.drawable.icon_czk
            "DKK" -> R.drawable.icon_dkk
            "GBP" -> R.drawable.icon_gbp
            "HKD" -> R.drawable.icon_hkd
            "HRK" -> R.drawable.icon_hrk
            "HUF" -> R.drawable.icon_huf
            "IDR" -> R.drawable.icon_idr
            "ILS" -> R.drawable.icon_ils
            "INR" -> R.drawable.icon_inr
            "ISK" -> R.drawable.icon_isk
            "JPY" -> R.drawable.icon_jpy
            "KRW" -> R.drawable.icon_krw
            "MXN" -> R.drawable.icon_mxn
            "MYR" -> R.drawable.icon_myr
            "NOK" -> R.drawable.icon_nok
            "NZD" -> R.drawable.icon_nzd
            "PHP" -> R.drawable.icon_php
            "PLN" -> R.drawable.icon_pln
            "RON" -> R.drawable.icon_ron
            "RUB" -> R.drawable.icon_rub
            "SEK" -> R.drawable.icon_sek
            "SGD" -> R.drawable.icon_sgd
            "THB" -> R.drawable.icon_thb
            "TRY" -> R.drawable.icon_try
            "USD" -> R.drawable.icon_usd
            "ZAR" -> R.drawable.icon_zar
            else -> R.drawable.icon_empty
        }
    }

    private fun mapSign(dto: RateDto): String {
        return when (dto.currency) {
            "EUR" -> "€"
            "AUD" -> "$"
            "BGN" -> "лв"
            "BRL" -> "R$"
            "CAD" -> "$"
            "CHF" -> "CHF"
            "CNY" -> "¥"
            "CZK" -> "Kč"
            "DKK" -> "kr"
            "GBP" -> "£"
            "HKD" -> "$"
            "HRK" -> "kn"
            "HUF" -> "Ft"
            "IDR" -> "Rp"
            "ILS" -> "₪"
            "INR" -> "₹"
            "ISK" -> "kr"
            "JPY" -> "¥"
            "KRW" -> "₩"
            "MXN" -> "$"
            "MYR" -> "RM"
            "NOK" -> "kr"
            "NZD" -> "$"
            "PHP" -> "₱"
            "PLN" -> "zł"
            "RON" -> "lei"
            "RUB" -> "₽"
            "SEK" -> "kr"
            "SGD" -> "$"
            "THB" -> "฿"
            "TRY" -> "₺"
            "USD" -> "$"
            "ZAR" -> "R"
            else -> "Unknown sign"
        }
    }
}