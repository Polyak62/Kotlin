package ru.tinkoff.memobot.entity

import javax.persistence.*

@Entity
class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    var id: Long? = null

    var name: String? = null

    var userId: Long? = null

}