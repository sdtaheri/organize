package com.raywenderlich.organize

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.round

actual class Platform actual constructor() {
  actual val osName = "Android"
  actual val osVersion = "${Build.VERSION.SDK_INT}"

  actual val deviceModel = "${Build.MANUFACTURER} ${Build.MODEL}"
  actual val cpuType = Build.SUPPORTED_ABIS.firstOrNull() ?: "---"

  private val metrics = Resources.getSystem().displayMetrics
  actual val screenWidth = metrics.widthPixels
  actual val screenHeight = metrics.heightPixels
  actual val screenDensity = round(metrics.density).toInt()

  actual fun logSystemInfo() {
    Log.d("Platform", userAgent)
  }
}
