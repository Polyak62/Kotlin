package ru.tinkoff.lesson4.dao

import ru.tinkoff.lesson4.emtity.Body
import java.util.*

class BodyDao {
    val bodies: Map<Int, Body> = mapOf(
        1 to Body(1, "yellow", "hatchback"),
        2 to Body(2, "yellow", "pickup"),
        3 to Body(3, "black", "crossover"),
        4 to Body(4, "black", "coupe"),
        5 to Body(5, "black", "minivan")
    )

    fun getAll(): List<Body> {
        val list: LinkedList<Body> = LinkedList()
        list.addAll(bodies.values)
        return list
    }

    fun findByVin(vin: Int): Body? {
        return bodies.get(vin)
    }
}