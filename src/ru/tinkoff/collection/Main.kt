package ru.tinkoff.collection

import ru.tinkoff.collection.dsl.queueOf
import ru.tinkoff.collection.dsl.stackOf
import ru.tinkoff.collection.queue.Queue
import ru.tinkoff.collection.stack.Stack


fun main() {
    var queue = queueOf("one", "two", "three")
    var stack = stackOf("four", "five", "six")



    println(queue.dequeue())

    println(stack.pop())



}