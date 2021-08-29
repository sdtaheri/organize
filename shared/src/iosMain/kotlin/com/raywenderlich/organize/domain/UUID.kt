package com.raywenderlich.organize.domain

import platform.Foundation.NSUUID

actual class UUID {
  private val value = NSUUID()
  actual override fun toString() = value.UUIDString
}