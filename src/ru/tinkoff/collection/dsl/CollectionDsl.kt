package ru.tinkoff.collection.dsl

import ru.tinkoff.collection.queue.Queue
import ru.tinkoff.collection.stack.Stack

fun <T> queueOf(vararg arg: T): Queue<T> {
    var que:Queue<T> = Queue()
    for(i in 0 until arg.size){
     que.enqueue(arg[i])
    }
    return que
}

fun <T> stackOf(vararg arg:T):Stack<T>{
    var st:Stack<T> = Stack()
    for(i in 0 until arg.size){
        st.push(arg[i])
    }
    return st
}