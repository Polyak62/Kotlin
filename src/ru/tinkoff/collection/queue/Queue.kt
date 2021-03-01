package ru.tinkoff.collection.queue

import java.util.*

class Queue<T> {

    private val list = LinkedList<T>()

    fun enqueue(obj: T) {
        list.add(obj)
    }

    fun dequeue(): T {
        if (list.isEmpty()) throw Exception("Очередь пуста")
        return list.removeAt(0)
    }



}