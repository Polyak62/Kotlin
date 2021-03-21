package ru.tinkoff.lesson5.dao

import ru.tinkoff.lesson5.entity.Memas
import ru.tinkoff.lesson5.entity.MemasMemasSource
import ru.tinkoff.lesson5.service.MySqlService
import java.lang.Exception
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class MemasDao {
    val mySqlservice: MySqlService = MySqlService()
    fun findById(id: Int): Memas? {
        var con: Connection? = null
        var rs: ResultSet? = null
        var stm: PreparedStatement? = null
        var memas: Memas? = null
        try {
            con = mySqlservice.createConnection()
            val script = "SELECT * FROM MEMAS WHERE MEMAS.ID = ? "
            stm = con.prepareStatement(script)
            stm.setInt(1, id)
            rs = stm.executeQuery()


            if (rs.next()) {
                val id = rs.getInt("id")
                val sourceId = rs.getInt("sourceId")
                val description = rs.getString("description")
                memas = Memas(id, sourceId, description)
            }
        } catch (e: Exception) {
            throw e
        } finally {
            rs?.close();
            stm?.close();
            con?.close();
        }
        return memas
    }

    fun joinMemasSource(): List<MemasMemasSource> {
        var con: Connection? = null
        var rs: ResultSet? = null
        var stm: PreparedStatement? = null
        var list = mutableListOf<MemasMemasSource>()
        try {
            con = mySqlservice.createConnection()
            val script = """SELECT Memas.sourceid, memassource.id , memassource.type, memas.description
         FROM Memas INNER JOIN memassource  
	     ON Memas.sourceid = memassource.id"""
            stm = con.prepareStatement(script)
            rs = stm.executeQuery()

            while (rs.next()) {
                val id = rs.getInt("SOURCEID")
                val sourceId = rs.getInt("ID")
                val type = rs.getString("type")
                val description = rs.getString("DESCRIPTION")
                list.add(MemasMemasSource(sourceId, id, description, type))
            }

        } catch (e: Exception) {
            throw e
        } finally {
            rs?.close();
            stm?.close();
            con?.close();
        }
        return list
    }

    fun sortMemasSourceByIdDesc(): List<Memas> {
        var con: Connection? = null
        var rs: ResultSet? = null
        var stm: PreparedStatement? = null
        var list = mutableListOf<Memas>()
        try {
            val script = "SELECT * FROM MEMAS ORDER BY SOURCEID DESC "
            con = mySqlservice.createConnection()
            stm = con.prepareStatement(script)
            rs = stm.executeQuery()
            while (rs.next()) {
                val id = rs.getInt("ID")
                val sourceId = rs.getInt("SOURCEID")
                val description = rs.getString("DESCRIPTION")
                list.add(Memas(id, sourceId, description))
            }

        } catch (e: Exception) {
            throw e
        } finally {
            rs?.close();
            stm?.close();
            con?.close();
        }
        return list
    }
}
