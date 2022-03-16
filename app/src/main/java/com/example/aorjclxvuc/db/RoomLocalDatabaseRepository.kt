package com.example.aorjclxvuc.db

import com.example.aorjclxvuc.db.entitiy.CurrencyInfoDBEntity

class RoomLocalDatabaseRepository(
    private val appDatabase: AppDatabase
) : LocalDatabaseRepository {

    override fun getCurrencyInfoList(isAsc: Boolean?): List<CurrencyInfoDBEntity> =
        isAsc?.let {
            appDatabase.currencyInfoDao().getAllCurrencyInfoRecordWithOrder(isAsc)
        } ?: appDatabase.currencyInfoDao().getAllCurrencyInfoRecord()
}
