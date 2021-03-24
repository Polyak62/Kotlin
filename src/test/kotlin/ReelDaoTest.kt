import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import io.mockk.slot
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.Assertions.assertEquals
import ru.tinkoff.lesson6.dao.ReelDao
import ru.tinkoff.lesson6.entity.Reel


@ExtendWith(MockKExtension::class)
class ReelDaoTest {
    val slotA = slot<Int>()

    @Test
    fun `should search reel by id`() {
        val reel = mockk<ReelDao>()
        every { reel.findId(capture(slotA)) } returns (Reel(1000))
        val reel2 = Reel(1000)
        val reel3 = reel.findId(1)
        assertEquals(reel2, reel3)
    }

    @Test
    fun `should return null search reel by id`() {
        val reel = mockk<ReelDao>()
        every { reel.findId(capture(slotA)) } returns null
        val reel1 = reel.findId(1)
        assertEquals(null, reel1)
    }
}
