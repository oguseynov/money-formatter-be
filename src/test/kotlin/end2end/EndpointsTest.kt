package end2end

import MoneyFormatterServer
import io.kotest.core.spec.style.ShouldSpec
import org.http4k.client.OkHttp
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Status.Companion.OK
import org.http4k.kotest.shouldHaveBody
import org.http4k.kotest.shouldHaveStatus

class EndpointsTest : ShouldSpec({
    val client = OkHttp()
    val server = MoneyFormatterServer(0)
    val baseUri: String by lazy {
        "http://localhost:${server.port()}"
    }

    beforeEach {
        server.start()
    }

    afterEach {
        server.stop()
    }

    should("respond to ping") {
        client(Request(Method.GET, "$baseUri/ping")) shouldHaveStatus OK
    }

    should("respond to format request") {
        val response = client(Request(Method.GET, "$baseUri/format?amount=1200.245"))
        response shouldHaveStatus OK
        response shouldHaveBody "1 200.25"
    }
})
