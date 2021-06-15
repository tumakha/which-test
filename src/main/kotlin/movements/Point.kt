package movements

/**
 * @author Yuriy Tumakha
 */
data class Point(val x: Int, val y: Int)

operator fun Point.plus(other: Point) = Point(x + other.x, y + other.y)
