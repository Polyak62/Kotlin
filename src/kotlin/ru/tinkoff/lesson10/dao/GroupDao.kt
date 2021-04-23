package ru.tinkoff.dao

import ru.tinkoff.entity.Group
import ru.tinkoff.lesson10.service.MySqlService
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class GroupDao {

    private val mySqlservice = MySqlService()

    fun findById(id:Long):Group {
        var con: Connection? = null
        var rs: ResultSet? = null
        var stm: PreparedStatement? = null
        var group: Group = Group(null, null)
        try {
            con = mySqlservice.createConnection()
            val script = "SELECT * FROM `GROUP` WHERE id=?"
            stm = con.prepareStatement(script)
            stm.setLong(1, id)
            rs = stm.executeQuery()
            if (rs.next()) {
                group = Group(rs.getLong("id"), rs.getString("name"))
            }
        } catch (e: Exception) {
            throw e
        } finally {
            rs?.close();
            stm?.close();
            con?.close();
        }
        return group
    }
}