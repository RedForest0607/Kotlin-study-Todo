package com.example.studyboard

import com.example.studyboard.dto.TodoDTO
import com.example.studyboard.dto.TodoRequest
import com.example.studyboard.dto.TodoResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todo")
class TodoController (
    private val todoService: TodoService
    ){

    @PostMapping("/")
    fun saveTodo(@RequestBody todoDTO: TodoDTO): TodoDTO = todoService.saveTodo(todoDTO)

    @GetMapping("/{id}")
    fun getTodo(@PathVariable id: Long): TodoDTO = todoService.findTodoOne(id)

    @GetMapping("/list")
    fun findTodoList(): List<TodoDTO> = todoService.findTodoList()

    @PutMapping("/{id}")
    fun updateTodo(@PathVariable id: Long, @RequestBody todoDTO: TodoDTO): TodoDTO = todoService.updateTodo(id, todoDTO)

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Long): TodoDTO = todoService.deleteTodo(id)

}