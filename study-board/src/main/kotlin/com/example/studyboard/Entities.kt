package com.example.studyboard

import com.example.studyboard.dto.TodoDTO
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Todo (
    val todoone: String,
    @Id @GeneratedValue
    val id: Long? = null
)
//entity 변수는 무조건 val!!!!!!!!!!!!!!!!!!!

fun Todo.toDTO() = TodoDTO(todoone = this.todoone, id = this.id)

