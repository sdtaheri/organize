package com.raywenderlich.organize.android.ui.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raywenderlich.organize.android.ui.about.AboutView
import com.raywenderlich.organize.android.ui.reminders.RemindersView

sealed class Screen(val route: String) {
  object Reminders : Screen("reminders")
  object AboutDevice : Screen("about-device")
}

@Composable
fun AppNavHost(
  navController: NavHostController,
  modifier: Modifier = Modifier,
) {
  NavHost(
    navController = navController,
    startDestination = Screen.Reminders.route,
    modifier = modifier,
  ) {
    composable(Screen.Reminders.route) {
      RemindersView(navController = navController)
    }

    composable(Screen.AboutDevice.route) {
      AboutView() {
        navController.popBackStack()
      }
    }
  }
}