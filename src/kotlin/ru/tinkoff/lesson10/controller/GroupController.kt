package ru.tinkoff.lesson10.controller

import ru.tinkoff.dao.GroupDao
import ru.tinkoff.entity.Group

class GroupController {

    private val groupDao: GroupDao = GroupDao()

    fun findById(id: Long): Group {
        return groupDao.findById(id)
    }
}