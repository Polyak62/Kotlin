package ru.tinkoff.studentservice.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import ru.tinkoff.studentservice.dao.FacultyDao
import ru.tinkoff.studentservice.entity.Faculty

@RestController
class FacultyController {

    @Autowired
    private lateinit var facultyDao: FacultyDao

    @GetMapping("/faculties/{id}")
    fun getFaculty(@PathVariable id: Long): Faculty? {
        return facultyDao.findById(id)
    }
}