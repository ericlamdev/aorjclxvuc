package com.example.aorjclxvuc.usecase

import com.example.aorjclxvuc.db.LocalDatabaseRepository
import com.example.aorjclxvuc.model.CurrencyInfo

class GetCurrencyInfoListUseCaseImpl(
    private val databaseRepository: LocalDatabaseRepository
) : GetCurrencyInfoListUseCase {

    override fun invoke(isAsc: Boolean?): List<CurrencyInfo> =
        databaseRepository.getCurrencyInfoList(isAsc)
            .map {
                CurrencyInfo.fromDB(it)
            }
}
