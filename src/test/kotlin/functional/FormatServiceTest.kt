package functional

import MoneyFormatterApp
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.BAD_REQUEST
import org.http4k.kotest.shouldHaveBody
import org.http4k.kotest.shouldHaveStatus

class FormatServiceTest : ShouldSpec({
    val client = MoneyFormatterApp()

    should("return properly formatted sting") {
        client(Request(GET, "/format?amount=0.0")) shouldHaveBody ".00"
    }

    should("return bad request if amount not provided") {
        val response: Response = client(Request(GET, "/format"))
        response shouldHaveStatus BAD_REQUEST
        response.status.description shouldBe "query 'amount' is required"
    }

    should("return bad request if amount is not BigDecimal") {
        val response = client(Request(GET, "/format?amount=not number"))
        response shouldHaveStatus BAD_REQUEST
        response.status.description shouldBe "query 'amount' must be number"

    }
})
