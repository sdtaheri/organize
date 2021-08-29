package com.raywenderlich.organize.presentation

import com.raywenderlich.organize.data.RemindersRepository
import com.raywenderlich.organize.domain.Reminder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RemindersViewModel(private val repository: RemindersRepository) : BaseViewModel() {
  val reminders: List<Reminder>
    get() = repository.reminders.sortedBy { it.isCompleted }

  val remindersFlow: Flow<List<Reminder>> =
    repository.remindersFlow.map { list ->
      list.sortedBy { it.isCompleted }
    }

  fun createReminder(title: String) {
    if (title.trim().isNotEmpty()) {
      repository.createReminder(title = title)
    }
  }

  fun markReminder(id: String, isCompleted: Boolean) {
    repository.markReminder(id = id, isCompleted = isCompleted)
  }

  fun deleteReminder(id: String) {
    repository.deleteReminder(id)
  }
}