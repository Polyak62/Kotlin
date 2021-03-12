package ru.tinkoff.lesson4.dao

import ru.tinkoff.lesson4.emtity.Frame


class FrameDao {
    val frames: Map<Int, Frame> = mapOf(
        1 to Frame(1, "carbon", "l"),
        2 to Frame(2, "fiber", "m"),
        3 to Frame(3, "steel 40", "xl"),
        4 to Frame(4, "steel 13h18", "xxl"),
        5 to Frame(5, "steel 18h18", "s")
    )

    fun getAll(): List<Frame> = frames.values.toList()


    fun findByVin(vin: Int): Frame? = frames[vin]
}