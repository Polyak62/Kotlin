package ru.tinkoff.lesson5.dao

import ru.tinkoff.lesson5.entity.Memas
import ru.tinkoff.lesson5.entity.MemasMemasSource
import ru.tinkoff.lesson5.service.MySqlService

class MemasDao {
    val mySqlservice: MySqlService = MySqlService()
    fun findById(id: Int): Memas? {
        val con = mySqlservice.createConnection()
        val script = "SELECT * FROM MEMAS WHERE MEMAS.ID = ? "
        val stm = con.prepareStatement(script)
        stm.setInt(1, id)
        val rs = stm.executeQuery()
        var memas: Memas? = null

        if (rs.next()) {
            val id = rs.getInt("id")
            val sourceId = rs.getInt("sourceId")
            val description = rs.getString("description")
            memas = Memas(id, sourceId, description)
        }
        rs.close();
        stm.close();
        con.close();
        return memas
    }

    fun joinMemasSource():List<MemasMemasSource> {
        val con = mySqlservice.createConnection()
        val script = """SELECT Memas.sourceid, memassource.id , memassource.type, memas.description
         FROM Memas INNER JOIN memassource  
	     ON Memas.sourceid = memassource.id"""

        val stm = con.prepareStatement(script)
        val rs = stm.executeQuery()
        val list: ArrayList<MemasMemasSource> = ArrayList()

        while (rs.next()) {
            val id = rs.getInt("SOURCEID")
            val sourceId = rs.getInt("ID")
            val type = rs.getString("type")
            val description = rs.getString("DESCRIPTION")
            list.add(MemasMemasSource(sourceId, id, description, type))
        }
        rs.close();
        stm.close();
        con.close();
        return list
    }

    fun sortMemasSource(): List<Memas> {
        val con = mySqlservice.createConnection()
        val script = "SELECT * FROM MEMAS ORDER BY SOURCEID DESC "
        val stm = con.prepareStatement(script)
        val rs = stm.executeQuery()
        val list: ArrayList<Memas> = ArrayList()

        while (rs.next()) {
            val id = rs.getInt("ID")
            val sourceId = rs.getInt("SOURCEID")
            val description = rs.getString("DESCRIPTION")
            list.add(Memas(id, sourceId, description))
        }
        rs.close();
        stm.close();
        con.close();
        return list
    }
}