package com.example.aorjclxvuc.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.aorjclxvuc.db.TableName
import com.example.aorjclxvuc.db.entitiy.CurrencyInfoDBEntity

@Dao
interface CurrencyInfoDao {

    @Query("SELECT * FROM ${TableName.CURRENCY_INFO} ORDER BY CASE WHEN :isAsc = 1 THEN name END ASC, CASE WHEN :isAsc = 0 THEN name END DESC, CASE WHEN :isAsc = null THEN null END")
    fun getAllCurrencyInfoRecord(isAsc: Boolean?): List<CurrencyInfoDBEntity>
}
