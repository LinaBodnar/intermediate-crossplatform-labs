package com.bodnar.lab6

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    initKoin()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Lab6",
    ) {
        App()
    }
}