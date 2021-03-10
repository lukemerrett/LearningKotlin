package a_introduction

// vararg allows you to pass any number of parameters
// Resolves to a list of a give type
// Just like the "params" keyword in C# (void UseParams(params int[] list))
fun printAll(vararg messages: String) {
    // Demonstrating a for each and inline expression processing the messages
    for (m in messages) println(m)
}

// Can still have leading or trailing parameters
fun printAllWithPrefix(vararg messages: String, prefix: String) {
    for (m in messages) println(prefix + m)
}

// List deconstruction showing how to pass from one vararg parameter to another
fun log(vararg entries: String) = printAll(*entries)

fun main() {
    printAll("Hello", "Hallo", "Salut", "Hola", "你好")

    // Explicit declaration of parameter to terminate the list of values in the messages parameter
    printAllWithPrefix(
        "Hello", "Hallo", "Salut", "Hola", "你好",
        prefix = "Greeting: "
    )

    log("A", "B", "C")
}