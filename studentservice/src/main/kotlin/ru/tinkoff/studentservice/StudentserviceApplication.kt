package ru.tinkoff.studentservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StudentserviceApplication

fun main(args: Array<String>) {
	runApplication<StudentserviceApplication>(*args)
}
