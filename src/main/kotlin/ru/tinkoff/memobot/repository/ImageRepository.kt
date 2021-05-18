package ru.tinkoff.memobot.repository

import org.springframework.data.repository.CrudRepository
import ru.tinkoff.memobot.entity.Image

interface ImageRepository: CrudRepository<Image, Long> {

    fun findAllByCategoryId(categoryId: Long): List<Image>
}