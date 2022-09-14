//package com.example.studyboard
//
//import com.example.studyboard.dto.TodoRequest
//import com.example.studyboard.dto.TodoResponse
//import com.example.studyboard.exception.NotFoundTodoIdException
//import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
//import com.ninjasquad.springmockk.MockkBean
//import io.mockk.every
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
//import org.springframework.boot.test.mock.mockito.MockBean
//import org.springframework.http.MediaType
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
//
//@WebMvcTest(TodoController::class)
//class ControllerTest (
//    @Autowired val mockMvc: MockMvc,
//    //@MockBean val todoService: TodoService
//) {
//
//    @MockkBean
//    lateinit var todoController: TodoController
//
//    @Test   //error - TodoRequest를 뭐로 설정하냐와 관계없이 returns TodoResponse만 따름. every를 지우면 no answer error
//    fun `post todo test - 정상 응답`() {
//        val todoRequest = TodoRequest("new todo2")
//        val json = jacksonObjectMapper().writeValueAsString(todoRequest)
//        every { todoController.saveTodo(todoRequest) } returns TodoResponse(1,"new todo")
//
//        mockMvc.perform(
//            post("/todo/")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(json)
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk)
//            .andExpect(jsonPath("\$.todoone").value("new todo"))
//            .andExpect(jsonPath("\$.id").value(1))
//
//    }
//
//
//    @Test
//    fun `get todo test - 정상 응답`() {
//        val todoResponse = TodoResponse(id = 1, "new todo")
//        every { todoController.getTodo(1) } returns todoResponse
//
//        mockMvc.perform(
//            get("/todo/1")
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk)
//            .andExpect(jsonPath("$.todoone").value("new todo"))
//    }
//
//    @Test
//    fun `get todo test - id에 해당하는 todo가 없는 경우`() {
//        every { todoController.getTodo(1) } throws NotFoundTodoIdException(1)
//
//        mockMvc.perform(get("/todo/1")
//            .contentType(MediaType.APPLICATION_JSON))
//            .andExpect(status().isNotFound)
//            .andDo(MockMvcResultHandlers.print())
//    }
//
//    @Test
//    fun `todo list test`() {
//        val todoResponse = TodoResponse(id = 1, "new todo")
//        val todoResponse2 = TodoResponse(id = 2, "new todo2")
//
//        every { todoController.getTodoList() } returns listOf(todoResponse, todoResponse2)
//
//        mockMvc.perform(
//            get("/todo/list")
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk)
//            .andExpect(jsonPath("\$.[0].todoone").value("new todo"))
//            .andExpect(jsonPath("\$.[1].todoone").value("new todo2"))
//    }
//
//    @Test
//    fun `update todo`() {
//        val todoRequest = TodoRequest("update todo")
//        val json = jacksonObjectMapper().writeValueAsString(todoRequest)
//        every { todoController.updateTodo(1, todoRequest) } returns TodoResponse(1, todoone = "update todo")
//
//        mockMvc.perform(put("/todo/1")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(json)
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk)
//            .andExpect(jsonPath("\$.todoone").value("update todo"))
//    }
//
//    @Test
//    fun `update todo - 404 Not Found`() {
//        val todoRequest = TodoRequest("update todo")
//        val json = jacksonObjectMapper().writeValueAsString(todoRequest)
//        every { todoController.updateTodo(1, todoRequest) } throws NotFoundTodoIdException(1)
//
//        mockMvc.perform(put("/todo/1")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(json)
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isNotFound)
//            .andDo(MockMvcResultHandlers.print())
//    }
//
//    @Test
//    fun `delete todo`() {
//        every { todoController.deleteTodo(1) } returns TodoResponse(1, todoone = "todo")
//
//        mockMvc.perform(delete("/todo/1")
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isOk)
//            .andExpect(jsonPath("\$.todoone").value("todo"))
//    }
//
//    @Test
//    fun `delete todo - 404 Not Found`() {
//        every { todoController.deleteTodo(1) } throws NotFoundTodoIdException(1)
//
//        mockMvc.perform(delete("/todo/1")
//            .accept(MediaType.APPLICATION_JSON))
//            .andExpect(status().isNotFound)
//            .andDo(MockMvcResultHandlers.print())
//    }
//}