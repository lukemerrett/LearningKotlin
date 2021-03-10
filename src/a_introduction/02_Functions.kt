package a_introduction

// Takes in 1 parameter of string type
// Returns nothing (Unit == no return)
fun printMessage(message: String): Unit {
    println(message)
}

// Parameters can be given default values, making them optional
fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    // Example of string interpolation in Kotlin using the dollar symbol
    println("[$prefix] $message")
}

// Simple return type
fun sum(x: Int, y: Int): Int {
    return x + y
}

// Single expression function returning an integer, type inferred from result of expression
fun multiply(x: Int, y: Int) = x * y

fun main() {
    printMessage("Hello")
    printMessageWithPrefix("Hello", "Log")
    printMessageWithPrefix("Hello") // Use default of prefix parameter
    printMessageWithPrefix(prefix = "Log", message = "Hello") // Explicit naming of params, can reorder them
    println(sum(1,2))
    println(multiply(2,4))
}