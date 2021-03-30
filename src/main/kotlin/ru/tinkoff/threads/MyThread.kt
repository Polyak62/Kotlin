package ru.tinkoff.threads

class MyThread:Thread() {
    override fun run() {
        println("Потоки ветра")
    }
}