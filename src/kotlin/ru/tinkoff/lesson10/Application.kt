package ru.tinkoff.kotlin.ru.tinkoff.lesson10

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import com.fasterxml.jackson.databind.*
import io.ktor.jackson.*
import io.ktor.features.*
import io.ktor.request.*
import org.flywaydb.core.Flyway
import ru.tinkoff.controller.StudentController
import ru.tinkoff.entity.Student
import ru.tinkoff.lesson10.controller.GroupController

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    migrate()
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }
    val studentController = StudentController()
    val groupController = GroupController()
    routing {
        get("/students") {
            call.respond(studentController.findAll())
        }

        post ("/student") {
            val parameters = call.receiveParameters()
            call.respond(studentController.save(Student(0L, parameters["name"]!!, parameters["groupId"]!!.toLong())))
        }

        put ("/student") {
            val parameters = call.receiveParameters()
            call.respond(studentController.update(Student(
                parameters["id"]!!.toLong(),
                parameters["name"]!!,
                parameters["groupId"]!!.toLong()
            )))
        }

        delete ("/students/{id}") {
            call.respond(studentController.delete(call.parameters["id"]!!.toLong()))
        }

        get("/groups/{id}") {
            val id = call.parameters["id"]
            call.respond(groupController.findById(id!!.toLong()))
        }

        get("/json/jackson") {
            call.respond(mapOf("hello" to "world"))
        }
    }
}


fun migrate() {
    Flyway
        .configure()
        .dataSource("jdbc:mysql://127.0.0.1:3306/test", "root", "62146214")
        .baselineOnMigrate(true)
        .locations("classpath:/db/migrations")
        .load()
        .migrate()
}

