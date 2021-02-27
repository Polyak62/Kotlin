package ru.tinkoff.collection

import ru.tinkoff.collection.queue.Queue
import ru.tinkoff.collection.stack.Stack


fun main() {
    val queue: Queue<String> = Queue()
    val stack: Stack<String> = Stack()


    queue.enqueue("one")
    queue.enqueue("two")
    queue.enqueue("three")
    println(queue.dequeue())

    stack.push("four")
    stack.push("five")
    stack.push("six")
    println(stack.pop())


}