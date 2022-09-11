package com.example.studyboard.java;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class TodoJava {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, length = 1000)
    private String todoone;
}
