package com.example.aorjclxvuc.db

import com.example.aorjclxvuc.db.entitiy.CurrencyInfoDBEntity

interface LocalDatabaseRepository {

    fun getCurrencyInfoList(): List<CurrencyInfoDBEntity>
}