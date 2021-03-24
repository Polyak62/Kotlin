import io.mockk.junit5.MockKExtension
import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import ru.tinkoff.lesson6.connectWithReel
import ru.tinkoff.lesson6.entity.Reel
import ru.tinkoff.lesson6.entity.Spinning
import java.lang.Exception

@ExtendWith(MockKExtension::class)
class SpinningTest {
    @Test(expected = Exception::class)
    fun `connectWithReel should throw exception on null `(){
        val spinning = Spinning(2.7, 20, "shimano")
        spinning.connectWithReel(null)
    }

    @Test
    fun `connectWithReel should not throw exception on reel` (){
        val spinning = Spinning(2.7, 20, "shimano")
        val reel = Reel(1500)
        spinning.connectWithReel(reel)
    }
}