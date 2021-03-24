package ru.tinkoff.lesson6.entity



data class Spinning(val length: Double, val test: Int, val model: String) {

    fun spinningCrashTest(test: Int): Boolean {
        return test <= this.test
    }

    fun foldInHalfSpinning(length: Double): Double {
        return length / 2
    }

}