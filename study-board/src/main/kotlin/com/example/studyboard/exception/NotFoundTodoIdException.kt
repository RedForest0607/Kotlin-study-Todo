package com.example.studyboard.exception

import org.springframework.http.HttpStatus

class NotFoundTodoIdException(
    id: Long
) : CommonException(
    code = 404,
    message = "$id : todo를 찾을 수 없습니다",
    status = HttpStatus.NOT_FOUND
)