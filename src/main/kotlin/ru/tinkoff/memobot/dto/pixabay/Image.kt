package ru.tinkoff.memobot.dto.pixabay

import com.fasterxml.jackson.annotation.JsonProperty

class Image {

    @JsonProperty("id")
    var id: Long? = null

    @JsonProperty("pageURL")
    var pageUrl: String? = null

    @JsonProperty("previewURL")
    var previewUrl: String? = null

    @JsonProperty("webformatURL")
    var webFormatUrl: String? = null

    @JsonProperty("largeImageURL")
    var largeImageUrl: String? = null

}