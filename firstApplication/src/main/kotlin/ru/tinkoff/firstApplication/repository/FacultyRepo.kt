package ru.tinkoff.firstApplication.repository

import org.springframework.data.repository.CrudRepository
import ru.tinkoff.firstApplication.entity.Faculty

interface FacultyRepo:CrudRepository<Faculty, Long> {
}