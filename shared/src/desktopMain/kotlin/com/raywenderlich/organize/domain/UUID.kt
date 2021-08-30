package com.raywenderlich.organize.domain

import java.util.UUID

actual class UUID {
  private val value: UUID = UUID.randomUUID()
  actual override fun toString() = value.toString()
}