package ru.tinkoff.dao

import ru.tinkoff.entity.Group
import ru.tinkoff.entity.Student
import ru.tinkoff.lesson10.service.MySqlService
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class StudentDao {

    private val mysqlService = MySqlService()

    fun findAll(): List<Student> {
        var con: Connection? = null
        var stm: PreparedStatement? = null
        var rs: ResultSet? = null
        val students = ArrayList<Student>()
        try {
            con = mysqlService.createConnection()
            val script = "SELECT * FROM STUDENT"
            stm = con.prepareStatement(script)
            rs = stm.executeQuery()
            if (rs.next()) {
                val id = rs.getLong("id")
                val name = rs.getString("name")
                val groupId = rs.getLong("group_id")
                students.add(Student(id, name, groupId))
            }
        } catch (e: Exception) {
            throw e
        } finally {
            rs?.close();
            stm?.close();
            con?.close();
        }
        return students
    }

    fun save(student: Student) {
        var con: Connection? = null
        var stm: PreparedStatement? = null
        try {
            con = mysqlService.createConnection()
            val script = "INSERT INTO STUDENT (name, group_id) VALUES (?, ?)"
            stm = con.prepareStatement(script)
            stm.setObject(1, student.name)
            stm.setLong(2, student.groupId)
            stm.execute()
        } catch (e: Exception) {
            throw e
        } finally {
            stm?.close();
            con?.close();
        }
    }

    fun update(student: Student){
        var con: Connection? = null
        var stm: PreparedStatement? = null
        try {
            con = mysqlService.createConnection()
            val script = "UPDATE STUDENT SET name=? , group_id=? WHERE ID=?"
            stm = con.prepareStatement(script)
            stm.setString(1, student.name)
            stm.setLong(2, student.groupId)
            stm.setLong(3, student.id)
            stm.execute()
        } catch (e: Exception) {
            throw e
        } finally {
            stm?.close()
            con?.close()
        }
    }

    fun delete(id:Long){
        var con: Connection? = null
        var stm: PreparedStatement? = null
        try {
            con = mysqlService.createConnection()
            val script = "DELETE FROM STUDENT WHERE ID=?"
            stm = con.prepareStatement(script)
            stm.setLong(1, id)
            stm.execute()
        } catch (e: Exception) {
            throw e
        } finally {
            stm?.close()
            con?.close()
        }
    }
}