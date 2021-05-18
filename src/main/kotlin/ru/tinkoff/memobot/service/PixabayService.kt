package ru.tinkoff.memobot.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import ru.tinkoff.memobot.dto.pixabay.PixabayResponse
import ru.tinkoff.memobot.exception.ImageNotFoundException
import java.io.File
import java.io.FileOutputStream


@Service
class PixabayService {

    @Value("\${pixabay.url}")
    lateinit var url: String

    @Value("\${pixabay.key}")
    lateinit var key: String

    fun findImage(name: String): PixabayResponse? {
        val restTemplate = RestTemplate()
        val response = restTemplate.getForObject(
            "${url}?key=${key}&image_type=photo&q=${name.replace(" ", "+")}",
            PixabayResponse::class.java
        )
        if (response!!.hits.isEmpty()) {
            throw ImageNotFoundException("image not found for ${name}")
        }
        return response
    }

    fun downloadImage(url: String): File {
        val restTemplate = RestTemplate()
        var headers: HttpHeaders = HttpHeaders();
        headers.set("User-Agent", "Mozilla/5.0 (X11; Linux x86_64; rv:48.0) Gecko/20100101 Firefox/48.0")
        var entity: HttpEntity<String> = HttpEntity("body", headers);
        val image = restTemplate.exchange(url, HttpMethod.GET, entity, ByteArray::class.java).body
        val file = File("./${url.substringAfterLast("/")}")
        FileOutputStream(file).use { stream -> stream.write(image) }
        return file
    }

    fun deleteImage(image: File) {
        image.delete()
    }
}