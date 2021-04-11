package ru.tinkoff.lesson.entity

class Computer (val maxCpu: Int, val maxGpu: Int) {

    fun canRun(game: Game): Boolean {
        return maxCpu >= game.cpu && maxGpu >= game.gpu
    }

    fun getSummaryPower(): Int {
        return maxCpu + maxGpu
    }
}