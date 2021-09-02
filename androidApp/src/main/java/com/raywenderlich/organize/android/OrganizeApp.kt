package com.raywenderlich.organize.android

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.raywenderlich.organize.initKoin
import com.raywenderlich.organize.presentation.AboutViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class OrganizeApp : Application() {
  override fun onCreate() {
    super.onCreate()

    initKoin(
      appModule = module {
        single<Context> { this@OrganizeApp }
        single<SharedPreferences> {
          get<Context>().getSharedPreferences("OrganizeApp", Context.MODE_PRIVATE)
        }
      },
      viewModelsModule = module {
        viewModel {
          AboutViewModel(get(), get())
        }
      }
    )
  }
}