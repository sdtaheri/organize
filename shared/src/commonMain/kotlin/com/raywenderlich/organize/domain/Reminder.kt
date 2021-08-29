package com.raywenderlich.organize.domain

data class Reminder(
  val id: String,
  val title: String,
  val isCompleted: Boolean = false,
)
