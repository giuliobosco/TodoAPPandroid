package ch.giuliobosco.todoappandroid.model.responses

import ch.giuliobosco.todoappandroid.model.Task

data class TaskDeleteResponse (
    val message: String,
    val task: Task
)