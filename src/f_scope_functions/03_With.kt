package f_scope_functions

import d_functional.Order

fun main() {
    // Not the same as "with" disposable scoping in other languages it seems
    // Instead it allows more concise access to its members
    data class Configuration(val host: String, val port: Int)
    fun Configuration.connect() {
        println("Connecting")
        println("Connected")
    }

    val config = Configuration("www.lukemerrett.com", 433)

    with(config) {
        println("$host:$port")
        connect()
    }

    // Instead of doing this
    println("${config.host}:${config.port}")
}