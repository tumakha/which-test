import movements.MovementsProcessor
import movements.Point
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author Yuriy Tumakha
 */
class MovementsProcessorTest {

    private val processor = MovementsProcessor()

    @Test
    fun runShortInstructions() {
        val movements = listOf("forward", "right", "forward", "left", "forward")
        assertEquals(Point(1, 2), processor.getLocation(movements))
    }

    @Test
    fun runLongInstructions() {
        val movements = listOf(
            "forward",
            "right",
            "forward",
            "forward",
            "forward",
            "left",
            "forward",
            "forward",
            "left",
            "right",
            "forward",
            "right",
            "forward",
            "forward",
            "right",
            "forward",
            "forward",
            "left"
        )
        assertEquals(Point(5, 2), processor.getLocation(movements))
    }

    @Test
    fun `handle movements empty list`() {
        assertEquals(Point(0, 0), processor.getLocation(listOf()))
    }

}
