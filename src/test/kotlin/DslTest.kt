import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import ru.tinkoff.lesson.dsl.asList
import ru.tinkoff.lesson.dsl.game
import ru.tinkoff.lesson.entity.Game

@ExtendWith(MockKExtension::class)
class DSLTest {

    @Test(expected = Exception::class)
    fun `asList should throw exception for more five games`() {
        Game("111", 111, 111).asList(
            Game("222", 222, 222),
            Game("333", 333, 333),
            Game("444", 444, 444),
            Game("555", 555, 555),
            Game("666", 666, 666),
            Game("777", 777, 777)
        )
    }

    @Test
    fun `asList should not throw exception for less five games`() {
        val list = Game("111", 111, 111).asList(
            Game("222", 222, 222),
            Game("333", 333, 333),
            Game("444", 444, 444),
            Game("555", 555, 555)
        )
        assert(list.size == 5)
    }

    @Test
    fun `asList should not throw exception for les`() {
        val game: Game = mockk(relaxed = true)
        every { game.name } returns "Far cry"
        every { game.cpu } returns 100
        every { game.gpu } returns 100

        val testGame = Game("Empty game", 0, 0)
        val result = testGame.game {
            this.name = game.name
            this.gpu = game.gpu
            this.cpu = game.cpu
        }
        assert(result.name.equals("Far cry"))
        assert(result.cpu == game.cpu)
        assert(result.gpu == game.gpu)
    }
}