import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.then
import org.http4k.filter.ServerFilters
import org.http4k.lens.Query
import org.http4k.lens.bigDecimal
import org.http4k.routing.bind
import org.http4k.routing.routes

fun MoneyFormatterApp(): HttpHandler = ServerFilters.CatchLensFailure.then(
    routes(
        "/ping" bind GET to { Response(OK) },
        "/format" bind GET to { request: Request ->
            val amount = Query.bigDecimal().required("amount")(request)
            Response(OK).body(format(amount))
        }
    )
)
