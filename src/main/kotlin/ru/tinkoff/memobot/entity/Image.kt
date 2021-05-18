package ru.tinkoff.memobot.entity

import javax.persistence.*

@Entity
class Image {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    var id: Long? = null
    var pixabayId: Long? = null
    var categoryId: Long? = null
    var url: String? = null
}