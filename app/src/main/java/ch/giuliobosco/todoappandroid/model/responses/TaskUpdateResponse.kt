package ch.giuliobosco.todoappandroid.model.responses

import ch.giuliobosco.todoappandroid.model.Task

data class TaskUpdateResponse (
    val message: String,
    val task: Task
)