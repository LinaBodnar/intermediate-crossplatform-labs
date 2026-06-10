package com.bodnar.lab6

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import io.github.aakira.napier.Napier

class AboutViewModel : ViewModel() {
    
    private val _uiState = MutableStateFlow(AboutUiState())

    val uiState: StateFlow<AboutUiState> = _uiState.asStateFlow()

    init {
        loadSystemInfo()
    }

    private fun loadSystemInfo() {
        Napier.d("AboutViewModel ініціалізовано. Завантажуємо дані платформи.", tag = "LAB7_LOG")

        val platform = getPlatform()

        _uiState.value = AboutUiState(
            platformName = platform.name,
            osVersion = platform.osVersion,
            deviceModel = platform.deviceModel
        )
    }
}