package ru.tinkoff

import ru.tinkoff.threads.*
import java.util.concurrent.Executors
import kotlin.concurrent.thread


fun main() {
    // task1()
    //task2()
    task3()

}

fun task1() {
    val tThread = MyThread()
    val tRunnable = Thread(MyRunnable())
    val tDsl = thread { println("Не беспокойся") }
    val tDaemon = MyDaemonThread()
    val tDemon = Thread(tDaemon)
    val tPriorityThread = MyPriorityThread()

    tThread.start()
    tRunnable.start()

    tDemon.setDaemon(true);
    tDemon.start()

    tPriorityThread.setPriority(Thread.MAX_PRIORITY)
    tPriorityThread.start()
}

fun task2() {
    val tWritingThread = WritingThread()
    val tWT = Thread(tWritingThread)
    val readThread1 = thread {
        while (true) {
            println("Thread one" + " " + tWritingThread.i.get())
        }
    }
    val readThread2 = thread {
        while (true) {
            println("Thread two" + " " + tWritingThread.i.get())
        }
    }
    val readThread3 = thread {
        while (true) {
            println("Thread three" + " " + tWritingThread.i.get())
        }
    }

    tWT.start()
}

fun task3() {
    val executor10 = Executors.newFixedThreadPool(10)
    val executor20 = Executors.newFixedThreadPool(20)
    val executor30 = Executors.newFixedThreadPool(30)

    val cD1 = CommandData()
    val cD2 = CommandData()
    val cD3 = CommandData()


    val timePool1Start = System.currentTimeMillis()
    while (cD1.getIncrement() < 1000000) {

        executor10.execute {
            synchronized(cD1) {
                if (cD1.getIncrement() < 1000000) {
                    cD1.increment()
                }
            }
        }
    }
    val timePool1End = System.currentTimeMillis()

    val timePool2Start = System.currentTimeMillis()
    while (cD2.getIncrement() < 1000000) {

        executor20.execute {
            synchronized(cD2) {
                if (cD2.getIncrement() < 1000000) {
                    cD2.increment()
                }
            }
        }
    }
    val timePool2End = System.currentTimeMillis()

    val timePool3Start = System.currentTimeMillis()
    while (cD3.getIncrement() < 1000000) {

        executor30.execute {
            synchronized(cD3) {
                if (cD3.getIncrement() < 1000000) {
                    cD3.increment()
                }
            }
        }
    }
    val timePool3End = System.currentTimeMillis()


    val deltaTime1 = timePool1End - timePool1Start
    val deltaTime2 = timePool2End - timePool2Start
    val deltaTime3 = timePool3End - timePool3Start


    println(cD1.i.get())
    println(cD2.i.get())
    println(cD3.i.get())

    println("first pool $deltaTime1")
    println("second pool $deltaTime2")
    println("third pool $deltaTime3")

}

