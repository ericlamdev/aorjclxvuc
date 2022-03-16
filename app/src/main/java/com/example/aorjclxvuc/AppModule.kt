package com.example.aorjclxvuc

import com.example.aorjclxvuc.usecase.GetCurrencyInfoListUseCase
import com.example.aorjclxvuc.usecase.GetCurrencyInfoListUseCaseImpl
import com.example.aorjclxvuc.viewmodel.DemoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    factory<GetCurrencyInfoListUseCase> {
        GetCurrencyInfoListUseCaseImpl(
            get()
        )
    }

    viewModel {
        DemoViewModel(
            get(),
            get()
        )
    }
}
