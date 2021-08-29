package com.raywenderlich.organize.data

import com.raywenderlich.organize.db.ReminderDb
import com.raywenderlich.organize.domain.Reminder
import com.raywenderlich.organize.domain.UUID
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RemindersRepository(private val databaseHelper: DatabaseHelper) {
  val reminders: List<Reminder>
    get() = databaseHelper.fetchAllItems().map { it.map() }

  val remindersFlow: Flow<List<Reminder>> = databaseHelper.fetchAllItemsAsFlow()
    .map { list ->
      list.map { it.map() }
    }

  fun createReminder(title: String) {
    databaseHelper.insertReminder(
      id = UUID().toString(),
      title = title,
    )
  }

  fun markReminder(id: String, isCompleted: Boolean) {
    databaseHelper.updateIsCompleted(id, isCompleted)
  }

  fun deleteReminder(id: String) {
    databaseHelper.deleteReminder(id)
  }
}

fun ReminderDb.map(): Reminder {
  return Reminder(
    id = this.id,
    title = this.title,
    isCompleted = this.isCompleted(),
  )
}