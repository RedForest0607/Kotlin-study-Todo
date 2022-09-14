package com.example.studyboard.dto

import com.example.studyboard.Todo

data class TodoDTO(
    val id: Long?,
    val todoone: String
)

fun TodoDTO.toEntity(): Todo = Todo(todoone = this.todoone, id = this.id)
//builder 만들어서 부생성자 사용x