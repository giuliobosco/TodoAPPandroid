package ch.giuliobosco.todoappandroid.model.responses

import ch.giuliobosco.todoappandroid.model.Task

data class TaskListResponse (
    val data: List<Task>
)