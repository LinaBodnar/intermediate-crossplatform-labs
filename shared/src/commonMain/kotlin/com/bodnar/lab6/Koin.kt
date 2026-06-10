package com.bodnar.lab6

import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf

val appModule = module {
    singleOf(::PlatformRepository)
    viewModelOf(::AboutViewModel)
}

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}