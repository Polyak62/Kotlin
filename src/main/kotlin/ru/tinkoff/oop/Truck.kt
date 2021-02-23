package ru.tinkoff.oop

class Truck(override val model: String,
            override val typeEngine: String,
            private var liftingCapacity: Int = 0) : Transport() {



    override fun maintenance() {
        printInfo()
        println("Техническое обслуживание ТС: Замена расодников ")
    }

    fun firstPoint() {
        if (liftingCapacity == 0) {
            liftingCapacity += 100500
            println("Машина загружена")
        } else println("Машина должна быть пустой")
    }

    fun secondPoint() {
        if (liftingCapacity == 100500) {
            liftingCapacity -= 100500
            println("Машина разгружена")
        } else println("Машина должна быть загружена")
    }


}