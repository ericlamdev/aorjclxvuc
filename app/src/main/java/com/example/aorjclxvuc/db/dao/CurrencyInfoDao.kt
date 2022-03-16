package com.example.aorjclxvuc.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.aorjclxvuc.db.TableName
import com.example.aorjclxvuc.db.entitiy.CurrencyInfoDBEntity

@Dao
interface CurrencyInfoDao {

    @Query("SELECT * FROM ${TableName.CURRENCY_INFO}")
    fun getAllCurrencyInfoRecord(): List<CurrencyInfoDBEntity>
}
