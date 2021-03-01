package ru.tinkoff.collection

import ru.tinkoff.collection.dsl.queueOf
import ru.tinkoff.collection.dsl.stackOf
import ru.tinkoff.collection.queue.Queue
import ru.tinkoff.collection.stack.Stack


fun main() {
    val queue = queueOf("one", "two", "three")
    val stack = stackOf("four", "five", "six")



    println(queue.dequeue())
    queue.enqueue("oneOne")
    queue.enqueue("oneTwo")
    queue.enqueue("oneThree")
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())
    println(queue.dequeue())


    stack.push("fourOne")
    stack.push("fourTwo")
    stack.push("fourThree")
    stack.push("fourFour")
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())



}