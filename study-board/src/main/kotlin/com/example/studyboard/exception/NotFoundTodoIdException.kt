package com.example.studyboard.exception

import org.springframework.http.HttpStatus

class NotFoundTodoIdException(
    id: Long
) : CommonException(
    code = "TODO_ID_NOT_FOUND",
    message = "$id : todo를 찾을 수 없습니다",
    status = HttpStatus.NOT_FOUND
)