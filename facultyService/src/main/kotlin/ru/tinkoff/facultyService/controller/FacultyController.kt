package ru.tinkoff.facultyService.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.webjars.NotFoundException
import ru.tinkoff.facultyService.dao.FacultyDao
import ru.tinkoff.facultyService.entity.Faculty

@RestController
class FacultyController {

    @Autowired
    private lateinit var facDao:FacultyDao

    @GetMapping("/faculty/{id}")
        fun getById(@PathVariable id:Long):Faculty?{
        val faculty = facDao.getById(id)
        if (faculty == null) {
            throw NotFoundException("faculty not found");
        }
        return faculty
    }
}