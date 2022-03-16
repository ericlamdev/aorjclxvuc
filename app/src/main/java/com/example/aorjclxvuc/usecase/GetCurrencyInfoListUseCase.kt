package com.example.aorjclxvuc.usecase

import com.example.aorjclxvuc.model.CurrencyInfo

interface GetCurrencyInfoListUseCase {

    operator fun invoke(isAsc: Boolean?): List<CurrencyInfo>
}