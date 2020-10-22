import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

fun format(number: BigDecimal): String {

    val decimalFormatSymbols = DecimalFormatSymbols()
    decimalFormatSymbols.groupingSeparator = ' '

    val decimalFormat = DecimalFormat("#,###.00", decimalFormatSymbols)
    decimalFormat.roundingMode = RoundingMode.HALF_UP

    return decimalFormat.format(number)
}
