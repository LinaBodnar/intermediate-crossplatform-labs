package com.bodnar.lab6

interface Platform {
    val name: String
    val osVersion: String
    val deviceModel: String
}

expect fun getPlatform(): Platform