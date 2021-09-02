plugins {
  id("com.android.application")
  kotlin("android")
}

dependencies {
  implementation(project(":shared"))
  implementation("com.google.android.material:material:1.4.0")
  implementation("androidx.appcompat:appcompat:1.3.1")
  implementation("androidx.constraintlayout:constraintlayout:2.1.0")
  implementation("androidx.compose.ui:ui:${rootProject.extra["compose_version"]}")
  implementation("androidx.compose.material:material:${rootProject.extra["compose_version"]}")
  implementation("androidx.compose.ui:ui-tooling:${rootProject.extra["compose_version"]}")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
  implementation("androidx.activity:activity-compose:1.3.1")
  implementation("androidx.navigation:navigation-compose:2.4.0-alpha08")
  implementation("com.russhwolf:multiplatform-settings:${rootProject.ext["settings_version"]}")
  implementation("io.insert-koin:koin-core:${rootProject.ext["koin_version"]}")
  implementation("io.insert-koin:koin-android:${rootProject.ext["koin_version"]}")
  androidTestImplementation("androidx.compose.ui:ui-test-junit4:${rootProject.extra["compose_version"]}")
}

android {
  compileSdk = 31
  defaultConfig {
    applicationId = "com.raywenderlich.organize.android"
    minSdk = 23
    targetSdk = 30
    versionCode = 1
    versionName = "1.0"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  lint {
    isAbortOnError = false
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
    }
  }

  buildFeatures {
    compose = true
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }

  kotlinOptions {
    jvmTarget = "1.8"
  }

  composeOptions {
    kotlinCompilerExtensionVersion = rootProject.extra["compose_version"] as String
  }
}