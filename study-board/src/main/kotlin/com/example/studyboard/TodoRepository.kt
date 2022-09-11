package com.example.studyboard

import com.example.studyboard.dto.TodoResponse
import org.springframework.data.repository.CrudRepository

interface TodoRepository: CrudRepository<Todo, Long> {
    fun findAllBy(): List<TodoResponse>
}