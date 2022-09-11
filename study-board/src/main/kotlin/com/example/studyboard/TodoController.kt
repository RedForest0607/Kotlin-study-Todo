package com.example.studyboard

import com.example.studyboard.dto.TodoRequest
import com.example.studyboard.dto.TodoResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todo")
class TodoController (
    private val todoService: TodoService
    ){

    //todo 저장
    @PostMapping("/")
    fun saveTodo(@RequestBody todoRequest: TodoRequest): TodoResponse = todoService.saveTodo(todoRequest)

    //todo 조회
    @GetMapping("/{id}")
    fun getTodo(@PathVariable id: Long): TodoResponse = todoService.findTodoOne(id)

    //todo list 조회
    @GetMapping("/list")
    fun getTodoList(): List<TodoResponse> = todoService.findTodoList()

    //todo 수정
    @PutMapping("/{id}")
    fun updateTodo(@PathVariable id: Long, @RequestBody todoRequest: TodoRequest): TodoResponse = todoService.updateTodo(id, todoRequest)

    //todo 삭제
    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Long): TodoResponse = todoService.deleteTodo(id)

}