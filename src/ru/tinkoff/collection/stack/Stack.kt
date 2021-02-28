package ru.tinkoff.collection.stack

import java.util.*

class Stack<T> {
    val list = LinkedList<T>()

    fun push(obj: T) {
        list.add(obj)
    }

    fun pop(): T {
        if (list.size > 0) {
            return list.removeAt(list.lastIndex)
        }
            throw Exception("Стек пуст")
    }
}