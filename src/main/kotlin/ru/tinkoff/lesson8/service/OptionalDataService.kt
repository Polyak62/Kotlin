package ru.tinkoff.lesson8.service

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

class OptionalDataService {

    suspend fun getData(): Deferred<String> = coroutineScope {
        async {
            delay(1000)
            "Optional data"
        }
    }
}