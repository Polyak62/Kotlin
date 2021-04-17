package ru.tinkoff.studentservice.dao

import org.springframework.stereotype.Repository
import ru.tinkoff.studentservice.entity.Student

@Repository
class StudentDao {

    val students: HashMap<Long, Student>

    constructor() {
        students = HashMap()
        students.put(1L, Student(1L, "Tolik1", 1L))
        students.put(2L, Student(2L, "Tolik2", 1L))
        students.put(3L, Student(3L, "Tolik3", 1L))
        students.put(4L, Student(4L, "Tolik4", 2L))
        students.put(5L, Student(5L, "Tolik5", 2L))
        students.put(6L, Student(6L, "Tolik6", 3L))
        students.put(7L, Student(7L, "Tolik7", 3L))
        students.put(8L, Student(8L, "Tolik8", 3L))
    }

    fun getAll(): Collection<Student> {
        return students.values
    }

    fun save(student: Student) {
        if (!students.containsKey(student.id)) {
            students.put(student.id, student)
        }
    }

    fun update(student: Student) {
        if (students.containsKey(student.id)) {
            students.put(student.id, student)
        }
    }

    fun delete(id: Long) {
        students.remove(id)
    }
}