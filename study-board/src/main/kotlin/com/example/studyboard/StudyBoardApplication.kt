package com.example.studyboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
class StudyBoardApplication


fun main(args: Array<String>) {
    runApplication<StudyBoardApplication>(*args)
}
