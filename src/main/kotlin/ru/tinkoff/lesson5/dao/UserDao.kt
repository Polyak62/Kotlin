package ru.tinkoff.lesson5.dao

import ru.tinkoff.lesson5.entity.User
import ru.tinkoff.lesson5.service.MySqlService
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet

class UserDao() {
    val mySqlservice: MySqlService = MySqlService()

    fun findById(id: Int): User? {
        var con: Connection? = null
        var rs: ResultSet? = null
        var stm: PreparedStatement? = null
        var user: User? = null
        try {
            con = mySqlservice.createConnection()
            val script = "SELECT * FROM USER WHERE USER.ID = ? "
            stm = con.prepareStatement(script)
            stm.setInt(1, id)
            rs = stm.executeQuery()


            if (rs.next()) {
                val id = rs.getInt("id")
                val userName = rs.getString("userName")
                val type = rs.getString("type")
                user = User(id, userName, type)
            }
        } catch (e: Exception) {
            throw e
        } finally {
            rs?.close();
            stm?.close();
            con?.close();
        }
        return user
    }

    fun findByIdRange(idMin: Int, idMax: Int): List<User> {
        var con: Connection? = null
        var rs: ResultSet? = null
        var stm: PreparedStatement? = null
        var list = mutableListOf<User>()

        try {
            con = mySqlservice.createConnection()
            val script = "SELECT * FROM USER WHERE USER.ID < ? AND USER.ID > ?"
            stm = con.prepareStatement(script)
            stm.setInt(2, idMin)
            stm.setInt(1, idMax)
            rs = stm.executeQuery()
            while (rs.next()) {
                val id = rs.getInt("id")
                val userName = rs.getString("userName")
                val type = rs.getString("type")
                list.add(User(id, userName, type))
            }
        } catch (e: java.lang.Exception) {
            throw e
        } finally {
            rs?.close();
            stm?.close();
            con?.close();
        }
        return list
    }

    fun getAll(): List<User> {
        var con: Connection? = null
        var rs: ResultSet? = null
        var stm: PreparedStatement? = null
        var list = mutableListOf<User>()
        try {
            con = mySqlservice.createConnection()
            val script = "SELECT * FROM USER ORDER BY ID DESC"
            stm = con.prepareStatement(script)
            rs = stm.executeQuery()
            while (rs.next()) {
                val id = rs.getInt("id")
                val userName = rs.getString("userName")
                val type = rs.getString("type")
                list.add(User(id, userName, type))
            }
        } catch (e: java.lang.Exception) {
            throw e
        } finally {
            rs?.close();
            stm?.close();
            con?.close();
        }
        return list
    }
}