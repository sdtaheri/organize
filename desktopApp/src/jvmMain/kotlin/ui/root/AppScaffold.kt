package ui

import AppNavHost
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppScaffold() {
  Scaffold {
    AppNavHost(
      modifier = Modifier
        .fillMaxSize()
        .padding(it)
    )
  }
}