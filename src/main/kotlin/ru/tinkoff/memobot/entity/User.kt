package ru.tinkoff.memobot.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    var id: Long? = null

    var vkId: String? = null
}