package com.example.aorjclxvuc.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyInfo(
    val id: String,
    val name: String,
    val symbol: String
): Parcelable {

    val firstLetter: String
        get() = name.first().toString()
}
