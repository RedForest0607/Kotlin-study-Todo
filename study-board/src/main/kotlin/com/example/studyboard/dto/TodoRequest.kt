package com.example.studyboard.dto

import com.example.studyboard.Todo

data class TodoRequest (val todoone: String)
//request + response => TodoDTO => service에서 사용
fun TodoRequest.toEntity() :Todo= Todo(todoone = this.todoone)