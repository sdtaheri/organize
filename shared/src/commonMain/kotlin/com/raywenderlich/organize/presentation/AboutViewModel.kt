package com.raywenderlich.organize.presentation

import com.raywenderlich.organize.Platform
import com.russhwolf.settings.Settings
import kotlinx.datetime.Clock
import kotlin.math.max
import kotlin.math.min

class AboutViewModel(
  platform: Platform,
  settings: Settings,
) : BaseViewModel() {

  val items = listOf<RowItem>(
    RowItem("Operating System", "${platform.osName} ${platform.osVersion}"),
    RowItem("Device", platform.deviceModel),
    RowItem("CPU", platform.cpuType),
    RowItem(
      "Display",
      "${
        max(platform.screenWidth, platform.screenHeight)
      }×${
        min(
          platform.screenWidth,
          platform.screenHeight
        )
      } @${platform.screenDensity}x"
    ),
  )

  // Epoch Seconds
  val firstOpen: Long

  init {
    val savedValue = settings.getLongOrNull(FIRST_OPEN)

    if (savedValue == null) {
      firstOpen = Clock.System.now().epochSeconds - 1
      settings.putLong(FIRST_OPEN, firstOpen)
    } else {
      firstOpen = savedValue
    }
  }

  data class RowItem(
    val title: String,
    val subtitle: String,
  )

  private companion object {
    const val FIRST_OPEN = "FIRST_OPEN"
  }
}