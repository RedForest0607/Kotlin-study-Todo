package com.example.studyboard.java;

import lombok.Getter;

@Getter
public class TodoRequestJava {

    String todoone;

    public static TodoJava newTodo(TodoRequestJava todoRequestJava) {
        TodoJava todoJava = new TodoJava();
        todoJava.setTodoone(todoRequestJava.getTodoone());

        return todoJava;
    }

}
