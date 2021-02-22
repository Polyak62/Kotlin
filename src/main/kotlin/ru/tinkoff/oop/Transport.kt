package ru.tinkoff.oop

interface Transport {
    val model: String
    val typeEngine: String

    fun maintenance()


    fun String.prettyPrint() {
        println("модель: $model, тип двигателя: $typeEngine")
        println(this)
        println()
    }
}