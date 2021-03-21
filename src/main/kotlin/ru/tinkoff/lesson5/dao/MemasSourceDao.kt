package ru.tinkoff.lesson5.dao

import ru.tinkoff.lesson5.entity.MemasSource
import ru.tinkoff.lesson5.service.MySqlService
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class MemasSourceDao {
    val mySqlservice: MySqlService = MySqlService()

    fun findById(id: Int): MemasSource? {
        var con: Connection? = null
        var rs: ResultSet? = null
        var stm: PreparedStatement? = null
        var memasSource: MemasSource? = null
        try {
            con = mySqlservice.createConnection()
            val script = "SELECT * FROM MEMASSOURCE WHERE MEMASSOURCE.ID = ? "
            stm = con.prepareStatement(script)
            stm.setInt(1, id)
            rs = stm.executeQuery()


            if (rs.next()) {
                val id = rs.getInt("id")
                val name = rs.getString("name")
                val type = rs.getString("type")
                memasSource = MemasSource(id, name, type)
            }
        } catch (e: Exception) {
            throw e
        } finally {
            rs?.close();
            stm?.close();
            con?.close();
        }
        return memasSource
    }

    fun countSoursesByType(): Int? {
        var con: Connection? = null
        var rs: ResultSet? = null
        var stm: PreparedStatement? = null
        var count: Int? = null
        try {
            con = mySqlservice.createConnection()
            val script = "SELECT COUNT(*) AS COUNT FROM MEMASSOURCE GROUP BY MEMASSOURCE.TYPE"
            stm = con.prepareStatement(script)
            rs = stm.executeQuery()

            if (rs.next()) {
                count = rs.getInt("COUNT")
            }
        } catch (e: java.lang.Exception) {
            throw e
        } finally {
            rs?.close();
            stm?.close();
            con?.close();
        }
        return count
    }
}