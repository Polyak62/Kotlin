package ru.tinkoff.oop

abstract class Transport {
   abstract val model: String
   abstract val typeEngine: String

    abstract fun maintenance()


    fun printInfo() {
        print("модель: $model, тип двигателя: $typeEngine   ")
    }
}