package com.vanphuc.coroutinedemo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BaseViewModel: ViewModel() {
    suspend fun postValueToApi() {
        viewModelScope.launch {
            delay(10000L)
            Log.d("TEST", "postValueToApi: Hello")
        }
    }
}