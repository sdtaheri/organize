import org.jetbrains.compose.compose

plugins {
  kotlin("multiplatform")
  id("com.android.library")
  id("com.squareup.sqldelight")
}

version = "1.0"

kotlin {
  android()

  val iosTarget: (String, org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget.() -> Unit) -> org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget = when {
    System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
//    System.getenv("NATIVE_ARCH")?.startsWith("arm") == true -> ::iosSimulatorArm64
    else -> ::iosX64
  }

  iosTarget("ios") {
    binaries {
      framework {
        baseName = "shared"
      }
    }
  }

  jvm("desktop")

  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation("io.insert-koin:koin-core:${rootProject.ext["koin_version"]}")
        implementation("com.russhwolf:multiplatform-settings:${rootProject.ext["settings_version"]}")
        implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.2.1")
        implementation("com.squareup.sqldelight:coroutines-extensions:1.5.1")
      }
    }
    val commonTest by getting {
      dependencies {
        implementation(kotlin("test-common"))
        implementation(kotlin("test-annotations-common"))
        implementation("io.insert-koin:koin-test:${rootProject.ext["koin_version"]}")
      }
    }
    val androidMain by getting {
      dependencies {
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
        implementation("androidx.core:core-ktx:1.6.0")
        implementation("com.squareup.sqldelight:android-driver:1.5.0")
      }
    }
    val androidTest by getting {
      dependencies {
        implementation(kotlin("test-junit"))
        implementation("junit:junit:4.13.2")
      }
    }
    val iosMain by getting {
      dependencies {
        implementation("com.squareup.sqldelight:native-driver:1.5.0")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0-native-mt") {
          version {
            strictly("1.5.0-native-mt")
          }
        }
      }
    }
    val iosTest by getting

    val desktopMain by getting {
      dependsOn(commonMain)
      dependencies {
        implementation(compose.desktop.common)
        implementation("com.squareup.sqldelight:sqlite-driver:1.5.0")
      }
    }
  }
}

android {
  compileSdk = 30
  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
  defaultConfig {
    minSdk = 23
    targetSdk = 30
  }
}

sqldelight {
  database("OrganizeDb") {
    packageName = "com.raywenderlich.organize"
  }
}