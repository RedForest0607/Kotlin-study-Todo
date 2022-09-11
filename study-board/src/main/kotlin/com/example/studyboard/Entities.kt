package com.example.studyboard

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Todo (
    var todoone: String,
    @Id @GeneratedValue
    val id: Long? = null
)

data class  CommonExceptionResponse (
    val code: String,
    val message: String
)