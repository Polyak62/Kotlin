package ru.tinkoff.memobot.repository

import org.springframework.data.repository.CrudRepository
import ru.tinkoff.memobot.entity.User

interface UserRepository: CrudRepository<User, Long> {

    fun findByVkId(vkId: String): User?
}