package com.bodnar.lab6

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform