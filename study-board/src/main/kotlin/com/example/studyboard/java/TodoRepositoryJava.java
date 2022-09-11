package com.example.studyboard.java;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepositoryJava extends JpaRepository<TodoJava, Long> {
    List<TodoResponseJava> findAllBy();
}
