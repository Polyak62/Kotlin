package ru.tinkoff.facultyService.dao

import org.springframework.stereotype.Service
import ru.tinkoff.facultyService.entity.Faculty


@Service
class FacultyDao {
    lateinit var fac: Map<Long, Faculty>
    constructor(){
      fac = mapOf(1L to Faculty(1L,"FAITU"),
              2L to Faculty(2L,"FVT"),
              3L to Faculty(3L,"FRT"),
              4L to Faculty(4L,"FE"))
    }


    fun getById(id:Long):Faculty? {
        return fac.get(id)
    }
}