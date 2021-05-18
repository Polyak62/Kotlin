package ru.tinkoff.memobot.bot.vk

import api.longpoll.bots.BotsLongPoll
import api.longpoll.bots.LongPollBot
import api.longpoll.bots.methods.messages.MessagesSend
import api.longpoll.bots.model.events.messages.MessageNewEvent
import api.longpoll.bots.model.objects.basic.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import ru.tinkoff.memobot.entity.Category
import ru.tinkoff.memobot.entity.Image
import ru.tinkoff.memobot.entity.User
import ru.tinkoff.memobot.exception.ImageNotFoundException
import ru.tinkoff.memobot.repository.CategoryRepository
import ru.tinkoff.memobot.repository.ImageRepository
import ru.tinkoff.memobot.repository.UserRepository
import ru.tinkoff.memobot.service.PixabayService
import javax.annotation.PostConstruct

@Component
class MemoBot : LongPollBot() {

    @Value("\${vk.groupId}")
    lateinit var groupId: String

    @Value("\${vk.accessToken}")
    lateinit var token: String

    @Autowired
    lateinit var pixabayService: PixabayService

    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var categoryRepository: CategoryRepository

    @Autowired
    lateinit var imageRepository: ImageRepository

    @PostConstruct
    fun init() {
        BotsLongPoll(this).run()
    }

    override fun onMessageNew(messageNewEvent: MessageNewEvent) {
        val message: Message = messageNewEvent.message
        if (message.hasText()) {
            var user = userRepository.findByVkId(message.fromId.toString())
            if (user == null) {
                val newUser = User()
                newUser.vkId = message.fromId.toString()
                user = userRepository.save(newUser)
            }
            var category = categoryRepository.findByUserIdAndName(user.id!!, message.text)
            if (category == null) {
                val newCategory = Category()
                newCategory.name = message.text
                newCategory.userId = user.id
                category = categoryRepository.save(newCategory)
            }
            val images = imageRepository.findAllByCategoryId(category.id!!)
            try {
                val response = pixabayService.findImage(message.text)
                val newImage = getNewImage(images, response!!.hits)
                if (newImage != null) {
                    newImage.categoryId = category.id
                    imageRepository.save(newImage)
                    val image = pixabayService.downloadImage(newImage.url!!)
                    MessagesSend(accessToken)
                            .setPeerId(message.getPeerId())
                            .addPhoto(image)
                            .execute()
                    pixabayService.deleteImage(image)
                } else {
                    MessagesSend(accessToken)
                            .setPeerId(message.getPeerId())
                            .setMessage("Хватит уже!!!")
                            .execute()
                }

            } catch (e: ImageNotFoundException) {
                MessagesSend(accessToken)
                        .setPeerId(message.getPeerId())
                        .setMessage("Слишком сложнааа!!!")
                        .execute()
            }
        }
    }

    fun getNewImage(shownImages: List<Image>, allImages: List<ru.tinkoff.memobot.dto.pixabay.Image>): Image? {
        for (image in allImages) {
            if (!shownImages.any { i -> i.pixabayId!!.equals(image.id) }) {
                var img = Image()
                img.url = image.webFormatUrl
                img.pixabayId = image.id
                return img
            }
        }
        return null
    }

    override fun getAccessToken(): String {
        return token
    }

    override fun getGroupId(): Int {
        return groupId.toInt()
    }
}