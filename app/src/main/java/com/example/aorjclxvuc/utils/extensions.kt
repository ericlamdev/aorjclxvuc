package com.example.aorjclxvuc.utils

import android.view.View
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

inline fun <T> Flow<T>.launchAndCollectIn(
    owner: LifecycleOwner,
    state: Lifecycle.State = Lifecycle.State.STARTED,
    crossinline block: suspend CoroutineScope.(data: T) -> Unit
) = owner.lifecycleScope.launch {
    owner.lifecycle.repeatOnLifecycle(state) {
        this@launchAndCollectIn.collect {
            block(it)
        }
    }
}

fun View.onSingleClick(action: () -> Unit) {
    setOnClickListener(object : OnSingleClickListener() {
        override fun onSingleClick(v: View?) {
            action.invoke()
        }
    })
}

