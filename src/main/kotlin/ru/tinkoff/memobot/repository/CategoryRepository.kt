package ru.tinkoff.memobot.repository

import org.springframework.data.repository.CrudRepository
import ru.tinkoff.memobot.entity.Category

interface CategoryRepository: CrudRepository<Category, Long> {

    fun findByUserIdAndName(userId: Long, name: String): Category?
}