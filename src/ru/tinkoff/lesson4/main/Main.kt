package ru.tinkoff.lesson4.main

import ru.tinkoff.lesson4.service.AutoService

fun main() {
    val bibika: AutoService = AutoService()

    println(bibika.getAutos())
    println(bibika.listAutoSort())
    println(bibika.listAutoGroup())
    println(bibika.quantityElements { it.vin > 3 })

}