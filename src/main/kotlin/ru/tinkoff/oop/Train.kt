package ru.tinkoff.oop

class Train(override val model: String, override val typeEngine: String) : Transport() {


    override fun maintenance(){
        printInfo()
        println("Техническое обслуживание ТС: постучать по колесам и проверить гудок")
    }


    fun maintenance(conductor: Conductor) {
        println("${conductor.name} наливает чай")
    }
}