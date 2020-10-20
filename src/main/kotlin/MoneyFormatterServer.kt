import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.server.Http4kServer
import org.http4k.server.Netty
import org.http4k.server.asServer

fun MoneyFormatterServer(port: Int): Http4kServer = { _: Request -> Response(OK) }.asServer(Netty(port))
