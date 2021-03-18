package ru.tinkoff.lesson5.service

class DdlService {
    val mySqlservice: MySqlService = MySqlService()

    private fun creatUserTable() {
        val con = mySqlservice.createConnection()
        val stm = con.createStatement()
        val script = """CREATE TABLE `test`.`user` (
                `id` INT NOT NULL AUTO_INCREMENT, 
                `userName` VARCHAR(45) NOT NULL,
                `type` VARCHAR(80) NOT NULL, 
                PRIMARY KEY (`id`),
                UNIQUE INDEX `name_UNIQUE` (`userName` ASC) VISIBLE,
                UNIQUE INDEX `type_UNIQUE` (`type` ASC) VISIBLE);"""
        val rs = stm.executeUpdate(script)
        stm.close();
        con.close();
    }

    private fun creatMemasTable() {
        val con = mySqlservice.createConnection()
        val stm = con.createStatement()
        val script = """CREATE TABLE `test`.`memas` ( 
                `id` INT NOT NULL AUTO_INCREMENT,
                `sourceId` INT NOT NULL,
                `description` VARCHAR(45) NOT NULL,
                PRIMARY KEY (`id`),
                UNIQUE INDEX `sourceId_UNIQUE` (`sourceId` ASC) VISIBLE,
                UNIQUE INDEX `description_UNIQUE` (`description` ASC) VISIBLE);"""
        val rs = stm.executeUpdate(script)
        stm.close();
        con.close();
    }

    private fun creatMemasSourceTable() {
        val con = mySqlservice.createConnection()
        val stm = con.createStatement()
        val script = """CREATE TABLE `test`.`memassource` (
                `id` INT NOT NULL AUTO_INCREMENT,
                `name` VARCHAR(45) NOT NULL,
                `type` VARCHAR(45) NOT NULL,
                PRIMARY KEY (`id`),
                UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE,
                UNIQUE INDEX `type_UNIQUE` (`type` ASC) VISIBLE);"""
        val rs = stm.executeUpdate(script)
        stm.close();
        con.close();
    }

    fun creatSchema() {
        creatUserTable()
        creatMemasTable()
        creatMemasSourceTable()
    }

    fun dellAllTable() {
        val con = mySqlservice.createConnection()
        val stm = con.createStatement()
        val scriptUser = "DROP TABLE USER"
        val scriptMemas = "DROP TABLE MEMAS"
        val scriptMemasSource = "DROP TABLE MEMASSOURCE"

        val rsU = stm.executeUpdate(scriptUser)
        val rsM = stm.executeUpdate(scriptMemas)
        val rsMS = stm.executeUpdate(scriptMemasSource)

        stm.close();
        con.close();
    }
}