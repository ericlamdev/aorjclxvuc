package com.example.aorjclxvuc.model

data class CurrencyInfo(
    val id: String,
    val name: String,
    val symbol: String
) {

    val firstLetter: String
        get() = name.first().toString()
}
