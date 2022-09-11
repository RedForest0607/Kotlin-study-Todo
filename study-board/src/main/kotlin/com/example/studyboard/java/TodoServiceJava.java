package com.example.studyboard.java;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TodoServiceJava {

    private final TodoRepositoryJava todoRepositoryJava;

    //todo 저장
    @Transactional
    public TodoResponseJava saveTodo(TodoRequestJava todoRequestJava) {
        return new TodoResponseJava(todoRepositoryJava.save(TodoRequestJava.newTodo(todoRequestJava)));
    }

    //todo 조회
}
