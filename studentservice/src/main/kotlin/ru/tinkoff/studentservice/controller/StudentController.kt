package ru.tinkoff.studentservice.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.tinkoff.studentservice.dao.StudentDao
import ru.tinkoff.studentservice.entity.Student

@RestController
class StudentController {

    @Autowired
    private lateinit var studentDao: StudentDao

    @GetMapping("/students")
    fun getStudents(): Collection<Student> {
        return studentDao.getAll()
    }

    @PostMapping("/student")
    fun save(@RequestBody student: Student) {
        studentDao.save(student)
    }

    @PutMapping("/student")
    fun update(@RequestBody student: Student) {
        studentDao.update(student)
    }

    @DeleteMapping("/student/{id}")
    fun delete(@PathVariable id: Long) {
        studentDao.delete(id)
    }


}