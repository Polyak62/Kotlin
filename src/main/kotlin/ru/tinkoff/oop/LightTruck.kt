package ru.tinkoff.oop

class LightTruck(override val model: String, override val typeEngine: String) : Transport() {


    fun highway() {
        println("${model} Едит там, где фурам нельзя")
    }

    override fun maintenance() {
        printInfo()
       println("Техническое обслуживание ТС: Кап.ремонт двигателя, заваривание дыр, замена подвески ")
       }
}