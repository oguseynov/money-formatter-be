package end2end

import MoneyFormatterServer
import io.kotest.core.spec.style.ShouldSpec
import org.http4k.client.OkHttp
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Status.Companion.OK
import org.http4k.kotest.shouldHaveStatus

class PingTest : ShouldSpec({
    val client = OkHttp()
    val server = MoneyFormatterServer(0)

    beforeEach {
        server.start()
    }

    afterEach {
        server.stop()
    }

    should("respond to ping") {
        client(Request(Method.GET, "http://localhost:${server.port()}/ping")) shouldHaveStatus OK
    }
})