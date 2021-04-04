package ru.tinkoff.lesson.dao

import ru.tinkoff.lesson.entity.Game

interface GameDao {

    fun findById(id: Long): Game?

    fun getAll(): List<Game>
}