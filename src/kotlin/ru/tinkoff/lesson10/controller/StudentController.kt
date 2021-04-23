package ru.tinkoff.controller

import ru.tinkoff.dao.StudentDao
import ru.tinkoff.entity.Student

class StudentController() {

    val studentDao = StudentDao()

    fun findAll(): List<Student> {
        return studentDao.findAll()
    }

    fun save(student: Student) {
        studentDao.save(student)
    }

    fun update(student: Student) {
        studentDao.update(student)
    }

    fun delete(id: Long) {
        studentDao.delete(id)
    }
}
