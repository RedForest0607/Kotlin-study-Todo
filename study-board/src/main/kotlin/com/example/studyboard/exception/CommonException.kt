package com.example.studyboard.exception

import org.springframework.http.HttpStatus

open class CommonException (
    val code: Int,
    message: String,
    val status: HttpStatus
) : RuntimeException(message)