package com.example.studyboard.java;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todojava")
public class TodoControllerJava {

    private final TodoServiceJava todoServiceJava;

    @PostMapping("/")
    public TodoResponseJava saveTodo(@RequestBody TodoRequestJava todoRequestJava) {
        System.out.println(todoRequestJava.getTodoone());
        return todoServiceJava.saveTodo(todoRequestJava);
    }
}
