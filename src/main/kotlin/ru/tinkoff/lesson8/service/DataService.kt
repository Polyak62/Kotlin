package ru.tinkoff.lesson8.service

import ru.tinkoff.lesson8.entity.Data

class DataService {

    val optionalDataService: OptionalDataService = OptionalDataService()
    val requiredDataService:MustHaveDataService = MustHaveDataService()

    suspend fun getData(): Data {
        val requiredData = requiredDataService.getData().await()
        val optionalData = optionalDataService.getData().await()
        return Data(optionalData, requiredData)
    }
}