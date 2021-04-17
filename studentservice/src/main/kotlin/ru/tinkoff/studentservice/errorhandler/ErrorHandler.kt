package ru.tinkoff.studentservice.errorhandler

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.client.HttpClientErrorException

@RestControllerAdvice
class ErrorHandler {

    @ExceptionHandler(HttpClientErrorException.NotFound::class)
    fun handleNotFoundException(): String {
        return "Not found"
    }
}