package api

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpClient.Redirect
import java.net.http.HttpClient.Version
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.nio.charset.StandardCharsets.UTF_8
import java.time.Duration

/**
 * @author Yuriy Tumakha
 */
class RestClient {

    private val log = LoggerFactory.getLogger(javaClass)

    companion object {
        private val mapper = ObjectMapper()
        private val httpClient: HttpClient = HttpClient.newBuilder()
            .version(Version.HTTP_2)
            .followRedirects(Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(10))
            .build()
    }

    fun get(url: String): JsonNode {
        log.debug("Request: GET {}", url)

        val request = HttpRequest.newBuilder()
            .uri(URI(url))
            .GET().build()
        val result = httpClient.send(request, BodyHandlers.ofString(UTF_8))
        val status = result.statusCode()
        val jsonResponse = result.body()

        log.debug("Response: {} {}", status, jsonResponse)
        return mapper.readTree(jsonResponse)
    }

}
