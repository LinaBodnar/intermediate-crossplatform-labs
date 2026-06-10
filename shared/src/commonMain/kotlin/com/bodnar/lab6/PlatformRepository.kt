package com.bodnar.lab6

class PlatformRepository {

    private var openCount = 0
    private var lastOpenTime = "Ніколи"

    fun fetchSystemInfo(): Platform {
        return getPlatform()
    }

    fun getOpenCount(): Int = openCount

    fun getLastOpenTime(): String = lastOpenTime

    fun incrementOpenCount() {
        openCount++
        lastOpenTime = "Клік №$openCount (актуальна сесія)"
    }
}