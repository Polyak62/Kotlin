package ru.tinkoff.lesson.dsl

import ru.tinkoff.lesson.entity.Game
import java.lang.Exception

fun Game.asList(vararg games: Game): List<Game> {
    val list = ArrayList<Game>()
    list.addAll(games)
    list.add(this)
    if (list.size > 5) {
        throw Exception("too many games")
    }
    return list
}

fun Game.game(function: Game.() -> Unit): Game {
    return this.apply(function)
}