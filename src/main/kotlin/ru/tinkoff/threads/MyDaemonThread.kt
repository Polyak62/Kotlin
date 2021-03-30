package ru.tinkoff.threads

class MyDaemonThread : Runnable {
    override fun run() {
        println("ведь тебя я не обижу")
    }
}