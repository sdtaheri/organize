package com.raywenderlich.organize.presentation

sealed class Screen(val route: String) {
  object Reminders : Screen("reminders")
  object AboutDevice : Screen("about-device")
}