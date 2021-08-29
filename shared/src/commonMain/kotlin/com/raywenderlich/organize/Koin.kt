package com.raywenderlich.organize

import com.raywenderlich.organize.data.DatabaseHelper
import com.raywenderlich.organize.data.RemindersRepository
import com.raywenderlich.organize.presentation.AboutViewModel
import com.raywenderlich.organize.presentation.RemindersViewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

expect val platformModule: Module

private val coreModule = module {
  factory { Platform() }
  single { DatabaseHelper(get()) }
}

private val viewModelsModule = module {
  factory { AboutViewModel(get(), get()) }
  factory { RemindersViewModel(get()) }
}

private val repositoriesModule = module {
  factory { RemindersRepository(get()) }
}

fun initKoin(appModule: Module): KoinApplication = startKoin {
  modules(
    coreModule,
    repositoriesModule,
    viewModelsModule,
    platformModule,
    appModule,
  )
}