package com.bodnar.lab6

data class AboutUiState(
    val platformName: String = "",
    val osVersion: String = "",
    val deviceModel: String = "",
    val openCount: Int = 0,        
    val lastOpenTime: String = ""
)