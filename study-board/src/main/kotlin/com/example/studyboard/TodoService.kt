package com.example.studyboard

import com.example.studyboard.dto.TodoRequest
import com.example.studyboard.dto.TodoResponse
import com.example.studyboard.exception.NotFoundTodoIdException
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TodoService(private val todoRepository: TodoRepository) {

    @Transactional
    fun saveTodo(todoRequest: TodoRequest): TodoResponse {
        val id = todoRepository.save(todoRequest.toEntity()).id
        return findTodoOne(id!!)
    }

    @Transactional
    fun findTodoOne(id: Long): TodoResponse {
        //findByIdOrNull -> kotlin에서 nullable 객체를 받을 수 있도록한 함수
        val todo = todoRepository.findByIdOrNull(id)?: throw NotFoundTodoIdException(id)
        return TodoResponse(todo)
    }

    @Transactional
    fun findTodoList() : List<TodoResponse> = todoRepository.findAllBy()

    @Transactional
    fun updateTodo(id: Long, request: TodoRequest) : TodoResponse {
        val todo = todoRepository.findByIdOrNull(id)?: throw NotFoundTodoIdException(id)
        todo.todoone = request.todoone
        todoRepository.save(todo)

        return TodoResponse(todo)
    }

    @Transactional
    fun deleteTodo(id: Long) : TodoResponse {
        val todo = todoRepository.findByIdOrNull(id)?: throw NotFoundTodoIdException(id)
        todoRepository.delete(todo)

        return TodoResponse(todo)
    }

}