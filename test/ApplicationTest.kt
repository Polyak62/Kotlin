package ru.tinkoff

import io.ktor.http.*
import kotlin.test.*
import io.ktor.server.testing.*
import ru.tinkoff.kotlin.ru.tinkoff.lesson10.module

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("HELLO WORLD!", response.content)
            }
        }
    }
}
