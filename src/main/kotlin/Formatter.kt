import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun format(number: BigDecimal, local: Locale = Locale.UK): String {

    val decimalFormatSymbols = DecimalFormatSymbols(local)
    decimalFormatSymbols.groupingSeparator = ' '

    val decimalFormat = DecimalFormat("#,###.00", decimalFormatSymbols)
    decimalFormat.roundingMode = RoundingMode.HALF_UP

    return decimalFormat.format(number)
}
