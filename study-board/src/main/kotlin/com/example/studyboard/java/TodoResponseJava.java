package com.example.studyboard.java;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TodoResponseJava {
    private Long id;
    private String todoone;

    public TodoResponseJava(TodoJava todo) {
        this.id = todo.getId();
        this.todoone = todo.getTodoone();
    }
}
