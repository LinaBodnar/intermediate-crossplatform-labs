package com.bodnar.lab6

import web.navigator.navigator

class JsPlatform: Platform {
    private val userAgent = navigator.userAgent
    private val browserList = listOf("Chrome", "Firefox", "Safari", "Edge")

    override val name: String = userAgent.findAnyOf(browserList, ignoreCase = true)
        ?.let { (startIndex) -> userAgent.substring(startIndex).substringBefore(" ") }
        ?: "Unknown"

    override val osVersion: String = userAgent.take(40) + "..."
    
    override val deviceModel: String = navigator.platform ?: "Web Browser"
}

actual fun getPlatform(): Platform = JsPlatform()