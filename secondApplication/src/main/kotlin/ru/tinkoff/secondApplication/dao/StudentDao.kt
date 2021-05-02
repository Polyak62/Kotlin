package ru.tinkoff.secondApplication.dao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.tinkoff.secondApplication.entity.Student
import ru.tinkoff.secondApplication.repository.StudentRepo

@Service
class StudentDao {
    @Autowired
    lateinit var studentRepo: StudentRepo

    fun findById(facultyId: Long): List<Student> {
        val studentRepo = studentRepo.findByFacultyId(facultyId)
        return studentRepo
    }
}