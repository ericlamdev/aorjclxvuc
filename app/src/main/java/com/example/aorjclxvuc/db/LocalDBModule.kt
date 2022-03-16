package com.example.aorjclxvuc.db

import androidx.room.Room
import com.example.aorjclxvuc.db.AppDatabase.Companion.DB_NAME
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localDBModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            DB_NAME
        ) .createFromAsset("database/currencyinfo.db").build()
    }

    factory<LocalDatabaseRepository> {
        RoomLocalDatabaseRepository(get())
    }
}
