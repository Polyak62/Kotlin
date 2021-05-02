package ru.tinkoff.firstApplication.dao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.tinkoff.firstApplication.entity.Faculty
import ru.tinkoff.firstApplication.entity.Student
import ru.tinkoff.firstApplication.entity.StudentList
import ru.tinkoff.firstApplication.repository.FacultyRepo
import java.util.*

@Service
class FacultyDao {
    @Autowired
    lateinit var facultyRepo: FacultyRepo

    fun findById(id: Long): Optional<Faculty> {
        val faculty = facultyRepo.findById(id)
        if (!faculty.isEmpty) {
            val restTemplate = RestTemplate()
            val list = restTemplate.getForObject("\${second.url}/students/${id}",StudentList::class.java)
            if (list != null) {
                faculty.get().listStudent = list.students
            }

        }
        return faculty
    }

}