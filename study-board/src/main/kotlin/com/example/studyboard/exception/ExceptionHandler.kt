package com.example.studyboard.exception

import com.example.studyboard.CommonExceptionResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(CommonException::class)
    fun commonExceptionHandler(e: CommonException) =
        ResponseEntity(
            CommonExceptionResponse(
                code = e.code,
                message = e.message?: "알 수 없는 오류"
            ),
            e.status,
        )

    //500대 에러는 서버 로그에서 확인하기 위해서
    @ExceptionHandler(RuntimeException::class)
    fun runtimeExceptionHandler(e: RuntimeException): ResponseEntity<CommonExceptionResponse> {
        e.printStackTrace()
        return ResponseEntity(
            CommonExceptionResponse(
                code = "INTERNAL_SERVER_ERROR",
                message = e.message?: "알 수 없는 오류",
            ),
            HttpStatus.INTERNAL_SERVER_ERROR,
        )
    }
}