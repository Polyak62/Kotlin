import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.extension.ExtendWith
import ru.tinkoff.lesson6.entity.Reel
import ru.tinkoff.lesson6.entity.Spinning
import org.junit.jupiter.api.Assertions.assertEquals
import ru.tinkoff.lesson6.connectWithReel
import ru.tinkoff.lesson6.createSpinningWithReel

@ExtendWith(MockKExtension::class)

class DslTest {
    @Test
    fun `should return null search reel by id`() {
        val spinning = Spinning(2.4, 15, "kosadaka")
        val reel = Reel(1500)

        assertEquals(spinning.connectWithReel(reel),createSpinningWithReel(spinning, reel))
    }
}