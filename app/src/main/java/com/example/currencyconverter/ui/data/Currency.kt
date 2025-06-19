package com.example.currencyconverter.ui.data

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class Currency(
    @DrawableRes val flag:Int,
    val name: String,
    val abbreviation: String,
    val course: Double,
    val sign: String,
    val amount: Double? = null
)


