package com.raywenderlich.organize

actual class Platform actual constructor() {
  actual val osName = System.getProperty("os.name") ?: "Desktop"
  actual val osVersion = System.getProperty("os.version") ?: "---"

  actual val deviceModel = "Desktop"
  actual val cpuType = System.getProperty("os.arch") ?: "---"

  actual val screenWidth = 0
  actual val screenHeight = 0
  actual val screenDensity = 0

  actual fun logSystemInfo() {
    print(userAgent)
  }
}
