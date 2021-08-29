package com.raywenderlich.organize.data

import com.raywenderlich.organize.OrganizeDb
import com.raywenderlich.organize.db.ReminderDb
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import kotlinx.coroutines.flow.Flow

class DatabaseHelper(
  sqlDriver: SqlDriver,
) {
  private val dbRef: OrganizeDb = OrganizeDb(sqlDriver)

  fun fetchAllItems(): List<ReminderDb> =
    dbRef.tableQueries
      .selectAll()
      .executeAsList()

  fun fetchAllItemsAsFlow(): Flow<List<ReminderDb>> =
    dbRef.tableQueries
      .selectAll()
      .asFlow()
      .mapToList()

  fun insertReminder(id: String, title: String) {
    dbRef.tableQueries.insertReminder(id, title)
  }

  fun updateIsCompleted(id: String, isCompleted: Boolean) {
    dbRef.tableQueries.updateIsCompleted(isCompleted.toLong(), id)
  }

  fun deleteReminder(id: String) {
    dbRef.tableQueries.deleteReminder(id)
  }
}

fun ReminderDb.isCompleted(): Boolean = this.isCompleted != 0L
internal fun Boolean.toLong(): Long = if (this) 1L else 0L