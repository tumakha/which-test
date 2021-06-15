package movements

/**
 * @author Yuriy Tumakha
 */
class MovementsProcessor {

    companion object {
        private val directions = arrayOf(Point(0, 1), Point(1, 0), Point(0, -1), Point(-1, 0))
    }

    fun getLocation(movements: List<String>): Point {
        var location = Point(0, 0)
        var d = 0

        fun rotate(step: Int) {
            d = (d + step) % 4
        }

        for (movement in movements) {
            when (movement) {
                "forward" -> location += directions[d]
                "right" -> rotate(1)
                "left" -> rotate(3)
                else -> throw IllegalArgumentException("Unknown movement: $movement")
            }
        }
        return location
    }

}
