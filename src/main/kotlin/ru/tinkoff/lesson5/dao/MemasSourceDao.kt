package ru.tinkoff.lesson5.dao

import ru.tinkoff.lesson5.entity.MemasSource
import ru.tinkoff.lesson5.entity.User
import ru.tinkoff.lesson5.service.MySqlService

class MemasSourceDao {
    val mySqlservice: MySqlService = MySqlService()

    fun findById(id: Int): MemasSource? {
        val con = mySqlservice.createConnection()
        val script = "SELECT * FROM MEMASSOURCE WHERE MEMASSOURCE.ID = ? "
        val stm = con.prepareStatement(script)
        stm.setInt(1, id)
        val rs = stm.executeQuery()
        var memasSource: MemasSource? = null

        if (rs.next()) {
            val id = rs.getInt("id")
            val name = rs.getString("name")
            val type = rs.getString("type")
            memasSource = MemasSource(id, name, type)
        }
        rs.close();
        stm.close();
        con.close();
        return memasSource
    }

    fun countSoursesByType():Int?{
        val con = mySqlservice.createConnection()
        val script = "SELECT COUNT(*) AS COUNT FROM MEMASSOURCE GROUP BY MEMASSOURCE.TYPE"
        val stm = con.prepareStatement(script)
        val rs = stm.executeQuery()
        var count:Int? = null
        if(rs.next()){
           count = rs.getInt("COUNT")
        }
        rs.close();
        stm.close();
        con.close();
        return count
    }

}