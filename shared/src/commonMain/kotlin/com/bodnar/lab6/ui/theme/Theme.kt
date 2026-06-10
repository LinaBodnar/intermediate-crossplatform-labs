package com.bodnar.lab6.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = DarkGreen,
    secondary = LightForestGreen,
    background = GreenBackground,          // Оновлюємо фон екрану
    primaryContainer = LightGreenContainer // Оновлюємо фон контейнера екрану
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}