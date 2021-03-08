package ru.tinkoff.lesson4.service

import ru.tinkoff.lesson4.dao.BodyDao
import ru.tinkoff.lesson4.dao.FrameDao
import ru.tinkoff.lesson4.emtity.Auto
import ru.tinkoff.lesson4.emtity.Frame
import java.util.*
import java.util.function.Predicate

class AutoService {
    private val bodyDao = BodyDao()
    private val frameDao = FrameDao()


    fun getAutos(): List<Auto> {
        val bodies = bodyDao.getAll()
        val listAuto: LinkedList<Auto> = LinkedList()

        for (i in bodies) {
            val f: Frame = frameDao.findByVin(i.vin)!!
            listAuto.add(Auto(i.vin, f.material, f.size, i.color, i.type))
        }
        return listAuto
    }

    fun listAutoSort(): List<Auto> {
        return getAutos().sortedBy { it.vin }
    }

    fun listAutoGroup(): Map<String, List<Auto>> {
        val group = getAutos().groupBy { it.color }
        return group
    }

    fun quantityElements(predicate: (Auto) -> Boolean): Int {
        return getAutos().filter(predicate).count()
    }
}