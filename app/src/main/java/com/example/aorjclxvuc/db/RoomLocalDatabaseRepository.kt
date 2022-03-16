package com.example.aorjclxvuc.db

import com.example.aorjclxvuc.db.entitiy.CurrencyInfoDBEntity

class RoomLocalDatabaseRepository(
    private val appDatabase: AppDatabase
) : LocalDatabaseRepository {

    override fun getCurrencyInfoList(): List<CurrencyInfoDBEntity> =
        appDatabase.currencyInfoDao().getAllCurrencyInfoRecord()
}
