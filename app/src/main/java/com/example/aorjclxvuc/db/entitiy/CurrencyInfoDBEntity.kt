package com.example.aorjclxvuc.db.entitiy

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.aorjclxvuc.db.TableName

@Entity(tableName = TableName.CURRENCY_INFO)
data class CurrencyInfoDBEntity(
    @NonNull @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "symbol") val symbol: String?
)
