package ru.tinkoff.entity

import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize
data class Student(var id: Long, var name: String, var groupId: Long) {
}