package ru.tinkoff.memobot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class MemobotApplication

fun main(args: Array<String>) {
	runApplication<MemobotApplication>(*args)
}
