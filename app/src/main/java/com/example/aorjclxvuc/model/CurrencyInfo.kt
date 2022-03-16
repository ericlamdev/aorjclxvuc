package com.example.aorjclxvuc.model

import android.os.Parcelable
import com.example.aorjclxvuc.db.entitiy.CurrencyInfoDBEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrencyInfo(
    val id: String,
    val name: String,
    val symbol: String
) : Parcelable {

    val firstLetter: String
        get() = name.first().toString()

    companion object {

        fun fromDB(entity: CurrencyInfoDBEntity): CurrencyInfo =
            CurrencyInfo(
                id = entity.id,
                name = entity.name.orEmpty(),
                symbol = entity.symbol.orEmpty()
            )
    }
}
