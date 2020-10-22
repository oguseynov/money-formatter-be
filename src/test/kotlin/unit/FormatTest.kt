package unit

import format
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll
import io.kotest.property.exhaustive.exhaustive
import myBigDecimals
import java.math.BigDecimal
import kotlin.math.log10

class FormatTests : FunSpec({
    test("result has 2 digits after dot") {
        checkAll(myBigDecimals) {
            val result = format(it)
            val len = result.length

            result[len - 3] shouldBe '.'
            result[len - 1].toInt() shouldBeGreaterThanOrEqual 0
            result[len - 2].toInt() shouldBeGreaterThanOrEqual 0
        }
    }

    test("no separation for 0, 10, 100") {
        val data = listOf(BigDecimal(0), BigDecimal(10), BigDecimal(100)).exhaustive()
        checkAll(data) {
            val result = format(it)
            result.split(' ') shouldHaveSize 1
        }
    }

    test("separation works as expected for 1000 and larger") {
        val data = Arb.int(1000, Int.MAX_VALUE)
        checkAll(data) {
            val result = format(it.toBigDecimal())
            result.split(' ') shouldHaveSize (log10(it.toDouble()).toInt() / 3) + 1
        }
    }

    test("separation works as expected for negative number") {
        format(BigDecimal(-100000.23)).split(' ') shouldHaveSize 2
    }
})
