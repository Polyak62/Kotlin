package ru.tinkoff.collection.queue

import java.util.*

class Queue<T> {

    val list = LinkedList<T>()

    fun enqueue(obj: T) {
        list.add(obj)
    }

    fun dequeue(): T {
        if (!list.isEmpty()) {
            return list.removeAt(0)
        }
        throw Exception("Очередь пуста")
    }



}