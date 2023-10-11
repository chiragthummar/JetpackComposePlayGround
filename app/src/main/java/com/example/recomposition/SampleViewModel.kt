package com.example.recomposition

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SampleViewModel : ViewModel() {

    private val _showMessage = MutableSharedFlow<String>()
    val showMessage get() = _showMessage.asSharedFlow()

    fun onClickA() {
        viewModelScope.launch {
            _showMessage.emit("My custom message")
        }
    }

}