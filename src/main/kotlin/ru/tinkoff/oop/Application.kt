package ru.tinkoff.oop

fun main() {
    val scania = Truck("Scania s500", "Dizel")
    val gazel = LightTruck("Gaz2301", "Gaz")
    val чучух = Train("РЖД228", "Coal")
    val lubaha = Conductor("Lubaha")

    scania.maintenance()
    gazel.maintenance()
    чучух.maintenance()
    чучух.maintenance(lubaha)

    scania.firstPoint()
    scania.secondPoint()
    gazel.highway()


}