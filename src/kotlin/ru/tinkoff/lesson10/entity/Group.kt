package ru.tinkoff.entity

import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize
data class Group(val id:Long?, val name:String?) {

}