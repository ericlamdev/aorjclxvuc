package com.example.aorjclxvuc.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.aorjclxvuc.db.dao.CurrencyInfoDao
import com.example.aorjclxvuc.db.entitiy.CurrencyInfoDBEntity

@Database(
    entities = [CurrencyInfoDBEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "app_db"
    }

    abstract fun currencyInfoDao(): CurrencyInfoDao
}
