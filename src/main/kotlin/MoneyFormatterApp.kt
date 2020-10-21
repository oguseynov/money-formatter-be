import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.then
import org.http4k.filter.ServerFilters
import org.http4k.routing.bind
import org.http4k.routing.routes

fun MoneyFormatterApp(): HttpHandler = ServerFilters.CatchLensFailure.then(
    routes(
        "/ping" bind GET to { Response(OK) }
    )
)
