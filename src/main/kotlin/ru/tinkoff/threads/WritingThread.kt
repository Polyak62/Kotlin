package ru.tinkoff.threads

import java.util.concurrent.atomic.AtomicInteger


class WritingThread : Runnable {
    @Volatile
    var i: AtomicInteger = AtomicInteger(0)

    override fun run() {
        while (i.get() < 10) {
            println(i.incrementAndGet())
            Thread.sleep(300)
        }
    }
}