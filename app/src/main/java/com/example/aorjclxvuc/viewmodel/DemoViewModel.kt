package com.example.aorjclxvuc.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.aorjclxvuc.model.CurrencyInfo
import com.example.aorjclxvuc.usecase.GetCurrencyInfoListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber

class DemoViewModel(
    app: Application,
    private val getCurrencyInfoListUseCase: GetCurrencyInfoListUseCase
) : AndroidViewModel(app) {

    private val _isSortByAscFlow: MutableStateFlow<Boolean?> = MutableStateFlow(null)
    val isSortByAscFlow: StateFlow<Boolean?> = _isSortByAscFlow.asStateFlow()

    private val _currencyInfoListFlow: MutableStateFlow<List<CurrencyInfo>?> =
        MutableStateFlow(null)
    val currencyInfoListFlow = _currencyInfoListFlow.asStateFlow()

//    val currencyInfoListFlow = combine(_sortOrderFlow, _currencyInfoListFlow) { order, list ->
//        order?.let {
//            when (order) {
//                SortOrder.ASC -> {
//                    list.sortedBy { it.name }
//                }
//                SortOrder.DSC -> {
//                    list.sortedByDescending { it.name }
//                }
//            }
//        } ?: list
//    }

    fun getCurrencyInfoList(isAsc: Boolean? = null) {
        _isSortByAscFlow.value = isAsc
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _currencyInfoListFlow.emit(getCurrencyInfoListUseCase(isAsc))
            } catch (e: Throwable) {
                Timber.e(e)
            }
        }
    }
}
