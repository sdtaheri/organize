package com.raywenderlich.organize

expect class Platform() {
  val osName: String
  val osVersion: String

  val deviceModel: String
  val cpuType: String

  val screenWidth: Int
  val screenHeight: Int
  val screenDensity: Int

  fun logSystemInfo()
}

val Platform.userAgent: String
  get() = "($osName; $osVersion; $deviceModel; ${screenWidth}x$screenHeight@${screenDensity}x; $cpuType)"
