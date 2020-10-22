import io.kotest.property.Arb
import io.kotest.property.arbitrary.double
import io.kotest.property.arbitrary.filterNot
import io.kotest.property.arbitrary.map

// Delete when DigDecimal Arb is fixed on kotest side
val myBigDecimals = Arb.double()
    .filterNot { it in setOf(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY) }
    .map { it.toBigDecimal() }
