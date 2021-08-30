package com.raywenderlich.organize

import com.russhwolf.settings.ExperimentalSettingsImplementation
import com.russhwolf.settings.JvmPreferencesSettings
import com.russhwolf.settings.Settings
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import org.koin.core.module.Module
import org.koin.dsl.module

@ExperimentalSettingsImplementation
actual val platformModule: Module = module {
  single<Settings> {
    JvmPreferencesSettings(get())
  }
  single<SqlDriver> {
//    val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:/Users/saeed/Developer/KotlinNative/organize/database/OrganizeDb.db")
    val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
    OrganizeDb.Schema.create(driver)
    driver
  }
}