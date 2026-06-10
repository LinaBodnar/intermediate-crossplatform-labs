package com.bodnar.lab6

import kotlinx.browser.window

class WebPlatform : Platform {
    override val name: String = "Web Browser"
    override val osVersion: String = window.navigator.userAgent.take(40) + "..."
    override val deviceModel: String = window.navigator.platform
}

actual fun getPlatform(): Platform = WebPlatform()