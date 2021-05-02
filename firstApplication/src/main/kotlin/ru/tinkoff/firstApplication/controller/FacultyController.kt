package ru.tinkoff.firstApplication.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.annotation.Id
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.tinkoff.firstApplication.dao.FacultyDao
import ru.tinkoff.firstApplication.entity.Faculty
import ru.tinkoff.firstApplication.repository.FacultyRepo
import java.util.*

@RestController
@RequestMapping("/faculty")
class FacultyController {

    @Autowired
    private lateinit var facultyDao: FacultyDao

    @GetMapping("/{id}")
    fun getFaculty(@PathVariable id: Long): Optional<Faculty> {
        return facultyDao.findById(id)
    }
}