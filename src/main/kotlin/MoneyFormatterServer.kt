import org.http4k.server.Http4kServer
import org.http4k.server.Netty
import org.http4k.server.asServer

fun MoneyFormatterServer(port: Int): Http4kServer = MoneyFormatterApp().asServer(Netty(port))

fun main() {
    MoneyFormatterServer(8000).start()
}
