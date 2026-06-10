package com.bodnar.lab6

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android"
    override val osVersion: String = "API ${Build.VERSION.SDK_INT}"
    override val deviceModel: String = "${Build.MANUFACTURER} ${Build.MODEL}"
}

actual fun getPlatform(): Platform = AndroidPlatform()