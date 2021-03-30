package ru.tinkoff.threads

import java.util.concurrent.Executor
import java.util.concurrent.atomic.AtomicInteger

class CommandData {

    @Volatile
    var i: AtomicInteger = AtomicInteger(0)

    fun increment() {
        i.incrementAndGet()

    }

    fun getIncrement(): Int {
        return i.get()
    }

}