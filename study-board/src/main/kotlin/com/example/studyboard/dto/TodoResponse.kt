package com.example.studyboard.dto

import com.example.studyboard.Todo

data class TodoResponse (
    val id: Long,
    val todoone: String
) {
    constructor(todo: Todo) : this(
        id = todo.id!!,
        todoone = todo.todoone
    )
}