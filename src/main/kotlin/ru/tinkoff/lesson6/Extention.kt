package ru.tinkoff.lesson6

import ru.tinkoff.lesson6.entity.Reel
import ru.tinkoff.lesson6.entity.Spinning
import ru.tinkoff.lesson6.entity.SpinningWithReel
import java.lang.Exception

fun Spinning.connectWithReel(reel: Reel?): SpinningWithReel {
    if (reel == null) {
        throw Exception("Плохая катушка")
    } else {
        return SpinningWithReel(this, reel)
    }
}

fun createSpinningWithReel(spinning: Spinning, reel: Reel):SpinningWithReel {
    return SpinningWithReel(spinning, reel)
}