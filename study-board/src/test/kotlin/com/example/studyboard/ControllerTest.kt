package com.example.studyboard

import com.example.studyboard.dto.TodoRequest
import com.example.studyboard.dto.TodoResponse
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.mockk
import org.hamcrest.MatcherAssert
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.lang.Exception

@WebMvcTest(TodoController::class)
class ControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var todoService: TodoService

    @MockkBean
    lateinit var todoController: TodoController

//    @Test
//    fun `save`() {
//        val todoRequest = TodoRequest("totototo")
//        val json = jacksonObjectMapper().writeValueAsString(todoRequest)
//        println(json)
//
//        mockMvc.perform(post("/todo/")
//            .content(json)
//            .contentType(MediaType.APPLICATION_JSON)
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk)
//    }

//    @Test
//    fun `List todos`() {
//        val todoRequest1 = TodoRequest(todoone = "todo1")
//        val todoRequest2 = TodoRequest(todoone = "todo2")
//        every { todoController.saveTodo(todoRequest = todoRequest1) } returns TodoResponse(id = 1, todoone = "todo1")
//        every { todoController.saveTodo(todoRequest = todoRequest2) } returns TodoResponse(id = 2, todoone = "todo2")
//        val todolist: MutableIterable<Todo> = todoController.getTodoList()
//
//        mockMvc.perform(get("/list").accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk)
//            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//            .andExpect(jsonPath("\$.[0].todoone").value("todo1"))
//    }

    @Test
    fun `post todo test - 정상 응답`() {
        val todoRequest = TodoRequest("new todo")

        every { todoController.saveTodo(todoRequest)} returns TodoResponse(1, "new todo")

        mockMvc.perform(
            post("/todo/")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("\$.todoone").value("new todo"))
    }


    @Test
    fun `get todo test - 정상 응답`() {
        val todoResponse = TodoResponse(id = 1, "new todo")
        every { todoController.getTodo(1) } returns todoResponse

        mockMvc.perform(
            get("/todo/1")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.todoone").value("new todo"))
    }

    @Test
    fun `get todo test - id에 해당하는 todo가 없는 경우`() {
        val todoResponse = TodoResponse(id = 1, "new todo")
        every { todoController.getTodo(1) } returns todoResponse

//        val responseBody = objectMapper.readValue<CommonExceptionResponse>(
//            mockMvc.perform(get("/todo/2")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isNotFound)
//                .andReturn()
//                .response
//                .contentAsString
//        )

    }

    //굳이 안해도 될듯
//    @Test
//    fun `get todo test - `() {
//        val todoResponse = TodoResponse(id = 1, "new todo")
//
//        every { todoController.getTodo(1) } returns todoResponse
//
//        mockMvc.perform(get("/todo/")
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isMethodNotAllowed)
//    }


    @Test
    fun `todo list test`() {
        val todoResponse = TodoResponse(id = 1, "new todo")
        val todoResponse2 = TodoResponse(id = 2, "new todo2")

        every { todoController.getTodoList() } returns listOf(todoResponse, todoResponse2)

        mockMvc.perform(
            get("/todo/list")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("\$.[0].todoone").value("new todo"))
            .andExpect(jsonPath("\$.[1].todoone").value("new todo2"))
    }

//    @Test
//    fun `get todo test`() {
//        `save todo test`()
//        every { todoController.getTodo(1)} returns TodoResponse(id = 1, todoone = "new todotodotdotodtodto")
//        every { todoController.getTodo(2)} throws IllegalArgumentException("[500] 해당 todo 없음")
//    }
//
//    @Test
//    fun `get todo list`() {
//        `save todo test`()
//    }
//
//    @Test
//    fun `update todo`() {
//        `save todo test`()
//        val sample = mockk<TodoRequest>()
//        //val todoRequest = TodoRequest("update todo")
//        every { todoController.updateTodo(1, sample) } returns TodoResponse(1, todoone = "update todo")
//        every { todoController.updateTodo(1, sample) } throws Exception("[400]HttpMessageNotReadableException: JSON parse error")
//        every { todoController.updateTodo(3, sample) } throws IllegalArgumentException("[500] 해당 todo 없음")
//    }
//
//    @Test
//    fun `delete todo`() {
//        `save todo test`()
//        every { todoController.deleteTodo(1) } returns TodoResponse(id = 1, todoone = "new todotodotdotodtodto")
//        every { todoController.deleteTodo(3) } throws IllegalArgumentException("[500] 해당 todo 없음")
//    }

}