package ru.tinkoff.lesson6.dao

import ru.tinkoff.lesson6.entity.Reel

interface ReelDao {
    fun findId(id:Int): Reel?
    fun getAll():List<Reel>
}