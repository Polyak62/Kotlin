package ru.tinkoff.secondApplication.repository

import org.springframework.data.repository.CrudRepository
import ru.tinkoff.secondApplication.entity.Student

interface StudentRepo:CrudRepository<Student, Long>{
    fun findByFacultyId(facultyId:Long):List<Student>
}