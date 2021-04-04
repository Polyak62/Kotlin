import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import ru.tinkoff.lesson.dao.GameDao
import ru.tinkoff.lesson.entity.Game

@ExtendWith(MockKExtension::class)
class GameDaoTest {

    var gameDao: GameDao = mockk(relaxed = true)

    @Test
    fun `findById for id more five should return null`() {
        every {gameDao.findById(more(5L))} returns null
        val game = gameDao.findById(10L)
        assert(game == null)
        verify {gameDao.findById(10L)}
    }

    @Test
    fun `findById for id less five should return game`() {
        every {gameDao.findById(less(5L))} returns Game("Far cry", 100, 100)
        val game = gameDao.findById(4L)
        assert(game != null)
        verify {gameDao.findById(4L)}
    }

    @Test
    fun `getAll should return game list`() {
        every {gameDao.getAll()} returns listOf(Game("Far cry", 100, 100))
        val list = gameDao.getAll()
        assert(!list.isEmpty())
        verify {gameDao.getAll()}
    }

}