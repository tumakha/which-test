package api

import movements.Point
import org.slf4j.LoggerFactory

/**
 * @author Yuriy Tumakha
 */
class WhichApiClient(email: String, apiBase: String = "https://which-technical-exercise.herokuapp.com") {

    private val log = LoggerFactory.getLogger(javaClass)
    private val getMovementsUrl = "$apiBase/api/$email/directions"
    private val checkLocationUrl = "$apiBase/api/$email/location"
    private val restClient = RestClient()

    init {
        log.debug("Email: $email")
        log.debug("API Base: $apiBase")
    }

    fun getMovements(): List<String> {
        return restClient.get(getMovementsUrl).get("directions").map { it.asText() }
    }

    fun checkLocation(location: Point): String {
        val (x, y) = location
        val url = "$checkLocationUrl/$x/$y"
        return restClient.get(url).get("message").asText()
    }

}
