package ru.tinkoff.studentservice.dao

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.tinkoff.studentservice.entity.Faculty

@Service
class FacultyDao {

    @Value("\${facultyServiceUrl}")
    lateinit var facultyServiceUrl: String;

    fun findById(id: Long): Faculty? {
        return RestTemplate()
            .getForEntity("${facultyServiceUrl}/faculty/${id}", Faculty::class.java)
            .body
    }
}