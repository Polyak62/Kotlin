package ru.tinkoff.lesson5

import ru.tinkoff.lesson5.dao.MemasDao
import ru.tinkoff.lesson5.dao.UserDao
import ru.tinkoff.lesson5.service.DdlService


fun main() {

    val ddl: DdlService = DdlService()
    val user: UserDao = UserDao()
    val memas: MemasDao = MemasDao()

    try {
        ddl.dellAllTable()
        ddl.creatSchema()
        println(memas.findById(3))
        println(memas.joinMemasSource())
        println(user.findByIdRange(1, 4))
        println(user.findAll())
    }catch (e: Exception){
        println("Ошибка работы с БД")
    }

}