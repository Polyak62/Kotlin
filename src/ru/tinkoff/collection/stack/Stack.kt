package ru.tinkoff.collection.stack

import java.util.*

class Stack<T> {
    private val list = LinkedList<T>()

    fun push(obj: T) {
        list.add(obj)
    }

    fun pop(): T {
        if (list.lastIndex> 0) {
            return list.removeAt(list.lastIndex)
        }
            throw Exception("Стек пуст")
    }
}