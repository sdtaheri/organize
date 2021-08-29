package com.raywenderlich.organize

import com.russhwolf.settings.AppleSettings
import com.russhwolf.settings.Settings
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import kotlinx.cinterop.ObjCClass
import kotlinx.cinterop.getOriginalKotlinClass
import org.koin.core.Koin
import org.koin.core.KoinApplication
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults

actual val platformModule: Module = module {
  single<SqlDriver> { NativeSqliteDriver(OrganizeDb.Schema, "OrganizeDb") }
}

fun initKoinIOS(
  userDefaults: NSUserDefaults,
): KoinApplication = initKoin(
  module {
    single<Settings> {
      AppleSettings(userDefaults)
    }
  }
)

fun Koin.get(objCClass: ObjCClass, qualifier: Qualifier?, parameter: Any): Any {
  val kClazz = getOriginalKotlinClass(objCClass)!!
  return get(kClazz, qualifier) { parametersOf(parameter) }
}

fun Koin.get(objCClass: ObjCClass, parameter: Any): Any {
  val kClazz = getOriginalKotlinClass(objCClass)!!
  return get(kClazz, null) { parametersOf(parameter) }
}

fun Koin.get(objCClass: ObjCClass, qualifier: Qualifier?): Any {
  val kClazz = getOriginalKotlinClass(objCClass)!!
  return get(kClazz, qualifier, null)
}

fun Koin.get(objCClass: ObjCClass): Any {
  val kClazz = getOriginalKotlinClass(objCClass)!!
  return get(kClazz, null, null)
}