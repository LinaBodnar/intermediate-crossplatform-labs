package com.bodnar.lab6

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import io.github.aakira.napier.Napier

class AboutViewModel(private val repository: PlatformRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(AboutUiState())
    val uiState: StateFlow<AboutUiState> = _uiState.asStateFlow()

    init {
        loadSystemInfo()
    }

    fun incrementCounterInUi() {
        repository.incrementOpenCount()
        loadSystemInfo()
    }

    private fun loadSystemInfo() {
        Napier.d("AboutViewModel: завантажуємо дані для Лаби 9", tag = "LAB9_LOG")

        val platform = repository.fetchSystemInfo()

        _uiState.value = AboutUiState(
            platformName = platform.name,
            osVersion = platform.osVersion,
            deviceModel = platform.deviceModel,
            openCount = repository.getOpenCount(),
            lastOpenTime = repository.getLastOpenTime()
        )
    }
}