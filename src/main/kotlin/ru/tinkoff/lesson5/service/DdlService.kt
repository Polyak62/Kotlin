package ru.tinkoff.lesson5.service

import java.sql.Connection
import java.sql.Statement

class DdlService {
    val mySqlservice: MySqlService = MySqlService()

    private fun creatUserTable() {
        var con: Connection? = null
        var stm: Statement? = null

        try {
            con = mySqlservice.createConnection()
            stm = con.createStatement()
            val script = """CREATE TABLE IF NOT EXISTS `test`.`user` (
                `id` INT NOT NULL AUTO_INCREMENT, 
                `userName` VARCHAR(45) NOT NULL,
                `type` VARCHAR(80) NOT NULL, 
                PRIMARY KEY (`id`),
                UNIQUE INDEX `name_UNIQUE` (`userName` ASC) VISIBLE,
                UNIQUE INDEX `type_UNIQUE` (`type` ASC) VISIBLE);"""
            stm.executeUpdate(script)
        } catch (e: Exception) {
            throw e
        } finally {
            stm?.close();
            con?.close();
        }
    }

    private fun creatMemasTable() {
        var con: Connection? = null
        var stm: Statement? = null

        try {
            con = mySqlservice.createConnection()
            stm = con.createStatement()
            val script = """CREATE TABLE IF NOT EXISTS `test`.`memas` ( 
                `id` INT NOT NULL AUTO_INCREMENT,
                `sourceId` INT NOT NULL,
                `description` VARCHAR(45) NOT NULL,
                PRIMARY KEY (`id`),
                UNIQUE INDEX `sourceId_UNIQUE` (`sourceId` ASC) VISIBLE,
                UNIQUE INDEX `description_UNIQUE` (`description` ASC) VISIBLE);"""
            stm.executeUpdate(script)
        } catch (e: Exception) {
            throw e
        } finally {
            stm?.close();
            con?.close();
        }
    }

    private fun creatMemasSourceTable() {
        var con: Connection? = null
        var stm: Statement? = null

        try {
            con = mySqlservice.createConnection()
            stm = con.createStatement()
            val script = """CREATE TABLE IF NOT EXISTS `test`.`memassource` (
                `id` INT NOT NULL AUTO_INCREMENT,
                `name` VARCHAR(45) NOT NULL,
                `type` VARCHAR(45) NOT NULL,
                PRIMARY KEY (`id`),
                UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
                UNIQUE INDEX `type_UNIQUE` (`type` ASC) VISIBLE);"""
            stm.executeUpdate(script)
        } catch (e: Exception) {
            throw e
        } finally {
            stm?.close();
            con?.close();
        }
    }

    fun creatSchema() {
        creatUserTable()
        creatMemasTable()
        creatMemasSourceTable()
    }

    fun dellAllTable() {
        val con = mySqlservice.createConnection()
        val stm = con.createStatement()

        try {
            val scriptUser = "DROP TABLE IF EXISTS USER"
            val scriptMemas = "DROP TABLE IF EXISTS  MEMAS"
            val scriptMemasSource = "DROP TABLE IF EXISTS  MEMASSOURCE"
            stm.executeUpdate(scriptUser)
            stm.executeUpdate(scriptMemas)
            stm.executeUpdate(scriptMemasSource)
        } catch (e: Exception) {
            throw e
        } finally {
            stm.close();
            con.close();
        }
    }
}