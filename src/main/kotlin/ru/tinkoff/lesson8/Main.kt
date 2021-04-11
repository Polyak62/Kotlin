package ru.tinkoff.lesson8

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import ru.tinkoff.lesson8.service.DataService

suspend fun CoroutineScope.events() = produce {
    for (i in 1..10) {
        delay(2000)
        send("event ${i}")
    }
}

fun main() = runBlocking {
    val dataService = DataService()
    println(dataService.getData())

    var events = events();
    repeat(10) {
        println(events.receive())
    }
}