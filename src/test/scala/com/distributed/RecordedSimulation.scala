package com.distributed

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("https://gmgauthier.com")
		.inferHtmlResources(BlackList(""".*\.css""", """.*\.js""", """.*\.ico"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/png,image/svg+xml,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-GB,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:130.0) Gecko/20100101 Firefox/130.0")

	val headers_0 = Map(
		"Priority" -> "u=0, i",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "none",
		"Sec-Fetch-User" -> "?1",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Priority" -> "u=4",
		"Sec-Fetch-Dest" -> "iframe",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_2 = Map(
		"Accept" -> "image/avif,image/webp,image/png,image/svg+xml,image/*;q=0.8,*/*;q=0.5",
		"Priority" -> "u=5, i",
		"Sec-Fetch-Dest" -> "image",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "same-origin")

	val headers_5 = Map(
		"Accept" -> "image/avif,image/webp,image/png,image/svg+xml,image/*;q=0.8,*/*;q=0.5",
		"Priority" -> "u=0, i",
		"Sec-Fetch-Dest" -> "image",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "same-origin")

	val headers_8 = Map(
		"Priority" -> "u=0, i",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1",
		"Upgrade-Insecure-Requests" -> "1")



	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/gw")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/gw/pages/intro.html")
			.headers(headers_1),
            http("request_2")
			.get("/gw/assets/img/gamma_world_cover.png")
			.headers(headers_2)))
		.pause(6)
		.exec(http("request_3")
			.get("/gw/pages/rolldice.html?t=1726675222012")
			.headers(headers_1))
		.pause(43)
		.exec(http("request_4")
			.get("/gw/pages/encounter.html?t=1726675266204")
			.headers(headers_1))
		.pause(2)
		.exec(http("request_5")
			.get("/gw/assets/img/checking.gif")
			.headers(headers_5))
		.pause(36)
		.exec(http("request_6")
			.get("/")
			.headers(headers_0)
			.resources(http("request_7")
			.get("/img/website-avatar-medium.png")
			.headers(headers_2)))
		.pause(10)
		.exec(http("request_8")
			.get("/contact/")
			.headers(headers_8))
		.pause(6)
		.exec(http("request_9")
			.get("/podcast/")
			.headers(headers_8))
		.pause(2)
		.exec(http("request_10")
			.get("/post/")
			.headers(headers_8))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}