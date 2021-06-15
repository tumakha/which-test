import api.WhichApiClient
import movements.MovementsProcessor

fun main() {
    val email = "tumakha@gmail.com"
    val apiClient = WhichApiClient(email)
    val processor = MovementsProcessor()

    val movements = apiClient.getMovements()
    val location = processor.getLocation(movements)
    println("Movements: $movements")
    println("Location: $location")

    val message = apiClient.checkLocation(location)
    println("Message: $message")
}
