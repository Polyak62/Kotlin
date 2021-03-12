package ru.tinkoff.lesson4.service

import ru.tinkoff.lesson4.dao.BodyDao
import ru.tinkoff.lesson4.dao.FrameDao
import ru.tinkoff.lesson4.emtity.Auto



class AutoService {
    private val bodyDao = BodyDao()
    private val frameDao = FrameDao()


    fun getAutos(): List<Auto> {
        return bodyDao.getAll().map {
            Auto(
                it.vin,
                frameDao.findByVin(it.vin)!!.material,
                frameDao.findByVin(it.vin)!!.size,
                it.color,
                it.type
            )
        }
    }

    fun listAutoSort(): List<Auto> = getAutos().sortedBy { it.vin }


    fun listAutoGroup(): Map<String, List<Auto>> = getAutos().groupBy { it.color }


    fun quantityElements(predicate: (Auto) -> Boolean): Int = getAutos().filter(predicate).count()
}
