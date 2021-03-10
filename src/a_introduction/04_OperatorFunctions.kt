package a_introduction

fun main() {
    // Functions can be upgraded to "operators", like infix but using specific symbols / syntax
    // Unsure how the "times" extension maps to "*" below, looks implicit based on the extension name
    // Or potentially is it an overload of an existing method called "times"?
    operator fun Int.times(str: String) = str.repeat(this)
    println(2 * "Bye ")

    // Allows us to apply a substring using an int range
    // Again it looks like theres an implicit mapping between "get" and "[]"
    operator fun String.get(range: IntRange) = substring(range)
    val str = "Always forgive your enemies; nothing annoys them so much."
    println(str[0..14])
}