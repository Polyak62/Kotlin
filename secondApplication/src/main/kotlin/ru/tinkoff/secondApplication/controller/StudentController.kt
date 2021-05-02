package ru.tinkoff.secondApplication.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.annotation.Id
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import ru.tinkoff.secondApplication.dao.StudentDao
import ru.tinkoff.secondApplication.entity.Student


@RestController
@RequestMapping("/students")
class StudentController {
    @Autowired
    private lateinit var studentDao: StudentDao

    @GetMapping("/{id}")
    fun getStudent(@PathVariable id: Long): List<Student> {
        return studentDao.findById(id)
    }
}
