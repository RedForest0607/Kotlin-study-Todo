package com.example.studyboard.dto

import com.example.studyboard.Todo

data class TodoRequest (val todoone: String) {
    fun toEntity(): Todo = Todo(
        todoone = todoone
    )
}