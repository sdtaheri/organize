buildscript {
    val compose_version by extra("1.0.2")
    val settings_version by extra("0.8")
    val koin_version by extra("3.1.2")

    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("org.jetbrains.compose:compose-gradle-plugin:1.0.0-alpha3")
        classpath("com.squareup.sqldelight:gradle-plugin:1.5.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}