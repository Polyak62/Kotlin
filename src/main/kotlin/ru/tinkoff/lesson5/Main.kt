package ru.tinkoff.lesson5

import ru.tinkoff.lesson5.dao.MemasDao
import ru.tinkoff.lesson5.dao.MemasSourceDao
import ru.tinkoff.lesson5.dao.UserDao
import ru.tinkoff.lesson5.service.DdlService


fun main() {

    val ddl: DdlService = DdlService()
    val user: UserDao = UserDao()
    val memas: MemasDao = MemasDao()
    val memasSourceDao = MemasSourceDao()

    try {
        ddl.creatSchema()
        println(memas.findById(3))
        println(memas.joinMemasSource())
        println(user.findByIdRange(1, 4))
        println(user.getAll())
        println(memasSourceDao.countSoursesByType())
        //ddl.dellAllTable()
    } catch (e: Exception) {
        println(e.message)
    }

}