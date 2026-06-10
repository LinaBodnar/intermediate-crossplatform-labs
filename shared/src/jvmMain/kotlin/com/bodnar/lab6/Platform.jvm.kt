package com.bodnar.lab6

class DesktopPlatform : Platform {
    override val name: String = "Desktop (JVM)"
    override val osVersion: String = System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")"
    override val deviceModel: String = System.getProperty("os.arch") // Архітектура процесора (наприклад, x86_64)
}

actual fun getPlatform(): Platform = DesktopPlatform()