package ru.tinkoff.lesson5.service

import java.sql.Connection
import java.sql.DriverManager

class MySqlService {
    val URL ="jdbc:mysql://127.0.0.1:3306/test"
    val USER = "root"
    val PASSWORD = "62146214"

    fun createConnection (): Connection = DriverManager.getConnection(URL,USER,PASSWORD)

}