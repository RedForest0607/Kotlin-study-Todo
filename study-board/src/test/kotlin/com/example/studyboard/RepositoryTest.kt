package com.example.studyboard

import com.example.studyboard.dto.TodoResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.util.*


@DataJpaTest
class RepositoryTest (
    @Autowired val entityManager: TestEntityManager,
    @Autowired val todoRepository: TodoRepository
){

    @Test
    fun `todo save and get test`() {
        val newTodo = Todo( "new todo!!!")
        entityManager.persist(newTodo)
        val todoOne = todoRepository.findByIdOrNull(newTodo.id!!)
        assertThat(todoOne).isEqualTo(newTodo)
    }

    @Test
    fun `todo list`(){
        val newTodo1 = Todo( "new todo1!!!")
        entityManager.persist(newTodo1)

        val newTodo2 = Todo( "new todo2!!!")
        entityManager.persist(newTodo2)

        val todolist: List<TodoResponse> = todoRepository.findAllBy()
        Assertions.assertEquals(todolist.size,2)
    }

    @Test
    fun `update todo`() {
        val newTodo1 = Todo( "new todo1!!!")
        entityManager.persist(newTodo1)

        val todo: Optional<Todo> = todoRepository.findById(1)

        entityManager.persist(todo)
        entityManager.flush()
    }

    @Test
    fun `delete todo`(){
        val newTodo = Todo( "new todo!!!")
        entityManager.persist(newTodo)

        todoRepository.delete(newTodo)
        Assertions.assertEquals(todoRepository.findAllBy().size,0)      //????이 방법밖에 없?
    }

}