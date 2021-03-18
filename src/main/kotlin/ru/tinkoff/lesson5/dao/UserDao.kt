package ru.tinkoff.lesson5.dao

import ru.tinkoff.lesson5.entity.User
import ru.tinkoff.lesson5.service.MySqlService

class UserDao() {
    val mySqlservice: MySqlService = MySqlService()

    fun findById(id: Int): User? {
        val con = mySqlservice.createConnection()
        val script = "SELECT * FROM USER WHERE USER.ID = ? "
        val stm = con.prepareStatement(script)
        stm.setInt(1, id)
        val rs = stm.executeQuery()
        var user: User? = null

        if (rs.next()) {
            val id = rs.getInt("id")
            val userName = rs.getString("userName")
            val type = rs.getString("type")
            user = User(id, userName, type)
        }
        rs.close();
        stm.close();
        con.close();
        return user
    }

    fun findByIdRange(idMin:Int, idMax:Int): List<User> {
        val con = mySqlservice.createConnection()
        val script = "SELECT * FROM USER WHERE USER.ID < ? AND USER.ID > ?"
        val stm = con.prepareStatement(script)
        stm.setInt(2,idMin)
        stm.setInt(1,idMax)
        val rs = stm.executeQuery()
        val list: ArrayList<User> = ArrayList()

        while(rs.next()){
            val id = rs.getInt("id")
            val userName = rs.getString("userName")
            val type = rs.getString("type")
            list.add(User(id, userName, type))
        }
        rs.close();
        stm.close();
        con.close();
        return list
    }

    fun findAll():List<User>{
        val con = mySqlservice.createConnection()
        val script = "SELECT * FROM USER ORDER BY ID DESC"
        val stm = con.prepareStatement(script)
        val rs = stm.executeQuery()
        val list: ArrayList<User> = ArrayList()

        while(rs.next()){
            val id = rs.getInt("id")
            val userName = rs.getString("userName")
            val type = rs.getString("type")
            list.add(User(id, userName, type))
        }
        rs.close();
        stm.close();
        con.close();
        return list
    }
}