package com.example.studyboard

import com.example.studyboard.dto.TodoDTO
import com.example.studyboard.dto.toEntity
import com.example.studyboard.exception.NotFoundTodoIdException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TodoService(private val todoRepository: TodoRepository) {

    @Transactional
    fun saveTodo(todoDTO: TodoDTO): TodoDTO {
        val id = todoRepository.save(todoDTO.toEntity()).id
        return findTodoOne(id!!)
    }

    @Transactional
    fun findTodoOne(id: Long): TodoDTO {
        //findByIdOrNull -> kotlin에서 nullable 객체를 받을 수 있도록한 함수
        val todo = todoRepository.findByIdOrNull(id)?: throw NotFoundTodoIdException(id)
        return todo.toDTO()
    }

    @Transactional
    fun findTodoList() : List<TodoDTO> = todoRepository.findAll().map { it.toDTO() }
    //return 값이 Iterable이므로 map으로 변환

    @Transactional
    fun updateTodo(id: Long, todoDTO: TodoDTO): TodoDTO {
        val todo = todoRepository.findByIdOrNull(id)?: throw NotFoundTodoIdException(id)
        val updateTodo = todo.toDTO().copy(id = todo.id, todoone = todoDTO.todoone)
        print(updateTodo.toEntity().id)
        val nextodo = todoRepository.save(updateTodo.toEntity())
        return nextodo.toDTO()
    }

    @Transactional
    fun deleteTodo(id: Long) : TodoDTO {
        val todo = todoRepository.findByIdOrNull(id)?: throw NotFoundTodoIdException(id)
        todoRepository.delete(todo)

        return todo.toDTO()
    }

}