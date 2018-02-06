import _root_.io.gatling.core.scenario.Simulation
import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.slf4j.LoggerFactory

import scala.concurrent.duration._

/**
 * Performance test for the RNS_REFR_MASTER entity.
 */
class RNS_REFR_MASTERGatlingTest extends Simulation {

    val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
    // Log all HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("TRACE"))
    // Log failed HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("DEBUG"))

    val baseURL = Option(System.getProperty("baseURL")) getOrElse """http://localhost:8080"""

    val httpConf = http
        .baseURL(baseURL)
        .inferHtmlResources()
        .acceptHeader("*/*")
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("fr,fr-fr;q=0.8,en-us;q=0.5,en;q=0.3")
        .connectionHeader("keep-alive")
        .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:33.0) Gecko/20100101 Firefox/33.0")

    val headers_http = Map(
        "Accept" -> """application/json"""
    )

    val headers_http_authentication = Map(
        "Content-Type" -> """application/json""",
        "Accept" -> """application/json"""
    )

    val headers_http_authenticated = Map(
        "Accept" -> """application/json""",
        "Authorization" -> "${access_token}"
    )

    val scn = scenario("Test the RNS_REFR_MASTER entity")
        .exec(http("First unauthenticated request")
        .get("/api/account")
        .headers(headers_http)
        .check(status.is(401))).exitHereIfFailed
        .pause(10)
        .exec(http("Authentication")
        .post("/api/authenticate")
        .headers(headers_http_authentication)
        .body(StringBody("""{"username":"admin", "password":"admin"}""")).asJSON
        .check(header.get("Authorization").saveAs("access_token"))).exitHereIfFailed
        .pause(1)
        .exec(http("Authenticated request")
        .get("/api/account")
        .headers(headers_http_authenticated)
        .check(status.is(200)))
        .pause(10)
        .repeat(2) {
            exec(http("Get all rNS_REFR_MASTERS")
            .get("/api/rns-refr-masters")
            .headers(headers_http_authenticated)
            .check(status.is(200)))
            .pause(10 seconds, 20 seconds)
            .exec(http("Create new rNS_REFR_MASTER")
            .post("/api/rns-refr-masters")
            .headers(headers_http_authenticated)
            .body(StringBody("""{"id":null, "rNSCATGCODE":"SAMPLE_TEXT", "sUBCODE1":"SAMPLE_TEXT", "sUBCODEDESC1":"SAMPLE_TEXT", "sUBCODE2":"SAMPLE_TEXT", "sUBCODEDESC2":"SAMPLE_TEXT", "sUBCODE3":"SAMPLE_TEXT", "sUBCODEDESC3":"SAMPLE_TEXT", "sUBCODE4":"SAMPLE_TEXT", "sUBCODEDESC4":"SAMPLE_TEXT", "sUBCODE5":"SAMPLE_TEXT", "sUBCODEDESC5":"SAMPLE_TEXT", "sUBCODE6":"SAMPLE_TEXT", "sUBCODEDESC6":"SAMPLE_TEXT", "sUBCODE7":"SAMPLE_TEXT", "sUBCODEDESC7":"SAMPLE_TEXT", "sUBCODE8":"SAMPLE_TEXT", "sUBCODEDESC8":"SAMPLE_TEXT", "sUBCODE9":"SAMPLE_TEXT", "sUBCODEDESC9":"SAMPLE_TEXT", "sUBCODE10":"SAMPLE_TEXT", "sUBCODEDESC10":"SAMPLE_TEXT", "sTATUS":"SAMPLE_TEXT", "cREATEDBY":"SAMPLE_TEXT", "cREATEDDATE":"2020-01-01T00:00:00.000Z", "lASTMODIFIEDBY":"SAMPLE_TEXT", "lASTMODIFIEDDATE":"2020-01-01T00:00:00.000Z"}""")).asJSON
            .check(status.is(201))
            .check(headerRegex("Location", "(.*)").saveAs("new_rNS_REFR_MASTER_url"))).exitHereIfFailed
            .pause(10)
            .repeat(5) {
                exec(http("Get created rNS_REFR_MASTER")
                .get("${new_rNS_REFR_MASTER_url}")
                .headers(headers_http_authenticated))
                .pause(10)
            }
            .exec(http("Delete created rNS_REFR_MASTER")
            .delete("${new_rNS_REFR_MASTER_url}")
            .headers(headers_http_authenticated))
            .pause(10)
        }

    val users = scenario("Users").exec(scn)

    setUp(
        users.inject(rampUsers(Integer.getInteger("users", 100)) over (Integer.getInteger("ramp", 1) minutes))
    ).protocols(httpConf)
}
