package com.raywenderlich.organize.android.helpers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import org.koin.androidx.viewmodel.ext.android.getViewModel

@Composable
inline fun <reified T : ViewModel> getViewModel(): T {
  val owner = LocalViewModelStoreOwner.current
  return remember {
    owner!!.getViewModel()
  }
}